/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.awt.List;

/**
 *
 * @author HQ
 */
public class Book {
    private int id;
    private String Bookname;
    private String author;
    private String Status;
    private int quantity;

    public Book(int id, String Bookname, String author, String Status, int quantity) {
        this.id = id;
        this.Bookname = Bookname;
        this.author = author;
        this.Status = Status;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookname(String Bookname) {
        this.Bookname = Bookname;
    }

    public String getBookname() {
        return Bookname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getStatus() {
        return Status;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    // Corrected getName() method
    public String getName() {
        return Bookname; // Return the book name
    }
}
