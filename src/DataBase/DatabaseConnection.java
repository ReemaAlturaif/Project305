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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Database URL and credentials
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/LibraryDB";
    //-------------put your username and password so DB works =)//-------------------
    private static final String USERNAME = "root";
    private static final String PASSWORD = "001279";

    // Private constructor to prevent instantiation
    private DatabaseConnection() {}

    // Method to establish and return a connection
    public static Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            throw e;  // Rethrow the exception after logging it
        }
        return con;
    }
}