
package DataBase;

import java.sql.Date;

public class User {
    private static User currentUser;
    private int id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String sex;

    public User() {
        
    }
     public User(int id, String username, String password, String email, String phoneNumber, String sex, Date birthday, String nationality) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.birthday = birthday;
        this.nationality = nationality;
    }

 public User(int id,String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.currentUser = currentUser;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    private Date birthday;
    private String nationality;

    public int getId() {
        return id;
    }
 public static User getCurrentUser() {
        return currentUser;
    }

    // Static method to set the current user (after login)
    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public String getUsername() {
        return username;
    }

}