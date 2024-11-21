/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

/**
 *
 * @author HQ
 */
import static DataBase.DatabaseConnection.getConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
//operations (Create, Read, Update, Delete)

public class book_CRUD {

    public static Book searchBook(String bookName, String author) {
        Book foundBook = null;
        String sql = "SELECT * FROM books WHERE bookName = ? AND author = ?";

        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, bookName);
            pstmt.setString(2, author);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("bookName");
                String bookAuthor = rs.getString("author");
                int quantity = rs.getInt("quantity");
                String status = rs.getString("status");

                foundBook = new Book(id, name, bookAuthor, status, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error searching for books: " + e.getMessage());
        }
        return foundBook; // Return null if no book is found
    }

    public void borrowBook(int borrowId, int bookId, int userId, String borrowDate, String returnDate) {
        String query = "INSERT INTO borrowings (id, userId, bookId, borrowDate, returnDate) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, borrowId);
            ps.setInt(2, userId);
            ps.setInt(3, bookId);
            ps.setString(4, borrowDate);
            if (returnDate == null) {
                ps.setNull(5, java.sql.Types.DATE);
            } else {
                ps.setString(5, returnDate);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creating borrowing record: " + e.getMessage());
        }
    }

    public void updateBookStatus(int bookId, int quantity) {
        String sql = "UPDATE books SET quantity = ?, status = ? WHERE id = ?";
        String status = (quantity > 0) ? "Available" : "Unavailable"; // Set status based on quantity

        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, quantity);
            pstmt.setString(2, status);
            pstmt.setInt(3, bookId);
            pstmt.executeUpdate();
            System.out.println("Book status updated successfully: Book ID " + bookId + ", Status " + status);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error updating book status: " + e.getMessage());
        }
    }

    public int getNextBorrowingId() {
        int maxId = 0;
        String sql = "SELECT MAX(id) FROM borrowings";

        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                maxId = rs.getInt(1); // Get the maximum existing ID
            }

            return maxId + 1; // Return next available ID
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving next borrowing ID: " + e.getMessage());
            return 1; // Default to 1 if there was an error (first borrowing)
        }
    }

    public List<Borrowing> getBorrowingHistory(int userId) {
        List<Borrowing> borrowingList = new ArrayList<>();
        String sql = "SELECT b.bookName, br.borrowDate, br.returnDate FROM borrowings br "
                + "JOIN books b ON br.bookId = b.id WHERE br.userId = ?";

        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String bookTitle = rs.getString("bookName");
                LocalDate borrowDate = (rs.getDate("borrowDate") != null)
                        ? rs.getDate("borrowDate").toLocalDate()
                        : null;
                LocalDate returnDate = (rs.getDate("returnDate") != null)
                        ? rs.getDate("returnDate").toLocalDate()
                        : null;

                borrowingList.add(new Borrowing(bookTitle, borrowDate, returnDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving borrowing history: " + e.getMessage());
        }
        return borrowingList;
    }

    public int getTotalBorrowedBooks(int userId) {
        int totalBooks = 0;
        String query = "SELECT COUNT(*) FROM borrowings WHERE userId = ? AND returnDate <> CURDATE()";

        try (Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, userId); // Set the user ID parameter
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                totalBooks = rs.getInt(1); // Get the count result
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalBooks;
    }

    public static boolean returnBook(int userId, String bookName) {
        String findBorrowingQuery
                = "SELECT br.bookId FROM borrowings br "
                + "JOIN books b ON br.bookId = b.id "
                + "WHERE br.userId = ? AND b.bookName = ? AND br.returnDate IS NULL";

        String updateBorrowingQuery
                = "UPDATE borrowings SET returnDate = CURDATE() WHERE userId = ? AND bookId = ?";
        String updateBookQuery
                = "UPDATE books SET quantity = quantity + 1 WHERE id = ?";

        try (Connection con = getConnection();
                PreparedStatement findStmt = con.prepareStatement(findBorrowingQuery)) {

            // Find the book being returned
            findStmt.setInt(1, userId);
            findStmt.setString(2, bookName);
            ResultSet rs = findStmt.executeQuery();

            if (rs.next()) {
                int bookId = rs.getInt("bookId");

                // Update the borrowing record with the return date
                try (PreparedStatement updateBorrowingStmt = con.prepareStatement(updateBorrowingQuery)) {
                    updateBorrowingStmt.setInt(1, userId);
                    updateBorrowingStmt.setInt(2, bookId);
                    updateBorrowingStmt.executeUpdate();
                }

                // Increment the book's quantity in the books table
                try (PreparedStatement updateBookStmt = con.prepareStatement(updateBookQuery)) {
                    updateBookStmt.setInt(1, bookId);
                    updateBookStmt.executeUpdate();
                }

                return true; // Return successful
            } else {
                System.out.println("No borrowing record found for userId: " + userId + " and bookName: " + bookName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return failed
    }

    public static int countOverdueBooks(int userId) {
        int count = 0;
        try (Connection con = getConnection()) {
            String query = "SELECT COUNT(*) AS overdueCount "
                    + "FROM borrowings "
                    + "WHERE userId = ? AND returnDate < CURDATE() AND returnDate IS NOT NULL";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, userId);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    count = rs.getInt("overdueCount");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

}
