/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Date;
import java.time.LocalDate;
/**
 *
 * @author HQ
 */
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