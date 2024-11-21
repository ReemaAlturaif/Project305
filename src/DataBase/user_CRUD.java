/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;


import static DataBase.DatabaseConnection.getConnection;
import java.sql.*;
import javax.swing.*;

/**

 *
 * @author HQ
 */
//operations (Create, Read, Update, Delete)
public class user_CRUD {
           public void addUser(int id, String username, String password, String email, String phoneNumber) {
        try (Connection con = getConnection()) {
            String query = "INSERT INTO users (id, username, password, email, phoneNumber) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, email);
            ps.setString(5, phoneNumber);
            ps.executeUpdate();
            System.out.println("User added successfully with ID: " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public int getNextUserId() {
    int maxId = 0;
    String sql = "SELECT MAX(id) FROM users";
    
    try (Connection con = getConnection();
         PreparedStatement pstmt = con.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {
        
        if (rs.next()) {
            maxId = rs.getInt(1); // Get the maximum existing ID
        }
        
        return maxId + 1; // Return next available ID
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error retrieving next user ID: " + e.getMessage());
        return 1;
    }
        }

public static User verifyUser(String username, String password) {
    String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
    try (Connection con = getConnection();
         PreparedStatement pstmt = con.prepareStatement(sql)) {
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id")); 
            user.setUsername(rs.getString("username"));
            user.setPhoneNumber(rs.getString("phoneNumber"));
            user.setEmail(rs.getString("email"));
            return user; // Return valid user
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error verifying user: " + e.getMessage());
    }
    return null; // Return null if no matching user is found
}
  public boolean updateUserInfo(int userId, String name, String email, String password) {
        String query = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setInt(4, userId);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0; // Return true if update was successful

        } catch (SQLException e) {
            e.printStackTrace(); 
            return false;
        }
    }
  
    public void updateUserProfile(int userId, String sex, java.sql.Date birthday, String nationality) {
        try (Connection con = getConnection()) {
            String query = "UPDATE users SET sex = ?, birthday = ?, nationality = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, sex);
            ps.setDate(2, birthday);
            ps.setString(3, nationality);
            ps.setInt(4, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating user profile: " + e.getMessage());
        }
    }

}


     

