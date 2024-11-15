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

public class DB_setUP {
    public static void CreateDatabase() 
   {
    try{
    // set the path for the database
    String ConnectionURL = "jdbc:mysql://localhost:3306";
    //Create Connection
    Connection con = null;
     //-------------put your username and password so DB works =)//-------------------
    con = DriverManager.getConnection(ConnectionURL,"root","root123");
    
    //CreateDatabase
    Statement st = con.createStatement();
    String database = "LibraryDB";
    //Check if the database exists
    ResultSet resultSet = st.executeQuery("SHOW DATABASES LIKE '" + database + "'");
            if (resultSet.next()) {
                // Database already exists, skip the rest of the method
                return;
            }
    st.executeUpdate("CREATE DATABASE "+database);
    
    System.out.println(database+" Created Sucessfully");
    
    createTablesAndInsertData(database);
    initializeBookstoDatabase();

    //close connection
    con.close();
    
        }catch (SQLException s){
         System.out.println("SQL statement is not executed!");
        }
 
        catch (Exception e){
          e.printStackTrace();
        }
            }
    //--------------------------------------------------------------------------
    private static void createTablesAndInsertData(String databaseName) { 
        
        Connection con = null;
        try{
        String connectionURL = "jdbc:mysql://localhost:3306/"+databaseName;        
        con = DriverManager.getConnection(connectionURL, "root", "root123");
        
        Statement st = con.createStatement();
        
                    String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT PRIMARY KEY," +
                    "username VARCHAR(255) UNIQUE NOT NULL," +
                    "password VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "phoneNumber VARCHAR(10) NOT NULL," +
                    "sex VARCHAR(255) DEFAULT NULL," +
                    "birthday DATE DEFAULT NULL," +
                    "nationality VARCHAR(255)DEFAULT NULL)";

            String createBooksTable = "CREATE TABLE IF NOT EXISTS books (" +
                    "id INT PRIMARY KEY," +
                    "bookName VARCHAR(255) NOT NULL," +
                    "author VARCHAR(255) NOT NULL," +
                    "quantity INT NOT NULL," +
                    "status VARCHAR(255))";

            String createBorrowingsTable = "CREATE TABLE IF NOT EXISTS borrowings (" +
                    "id INT PRIMARY KEY," +
                    "userId INT," +
                    "bookId INT," +
                    "borrowDate DATE," +
                    "returnDate DATE," +
                    "FOREIGN KEY (userId) REFERENCES users(id)," +
                    "FOREIGN KEY (bookId) REFERENCES books(id))";
    
    st.executeUpdate(createUsersTable);
    st.executeUpdate(createBooksTable);
    st.executeUpdate(createBorrowingsTable);
 
    System.out.println("Tables Created Successfully");
        
        }catch (SQLException e) {
            System.out.println("Error creating tables or inserting data: " + e.getMessage());
        }
    }
    
    public static void initializeBookstoDatabase() {
        try (Connection con = getConnection()) {
              String[] books = {
           "(1, 'CPIT252', 'Fatima', 5, 'Available')",
           "(2, 'CPIT330', 'Hanan', 5, 'Available')",
           "(3, 'CPIT425', 'Suheer', 1, 'Available')",
            "(4, 'CPIT334', 'Suaad', 1, 'Available')"
            };

            for (String book : books) {
                String query = "INSERT INTO books (id ,bookName, author,quantity, status) VALUES " + book;
                PreparedStatement ps = con.prepareStatement(query);
                ps.executeUpdate();
            }

            System.out.println("Initial books added to the database.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
    