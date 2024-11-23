
package DataBase;


import java.time.LocalDate;

public class Borrowing {
    private String bookTitle;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Borrowing(String bookTitle, LocalDate borrowDate, LocalDate returnDate) {
        this.bookTitle = bookTitle;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
}