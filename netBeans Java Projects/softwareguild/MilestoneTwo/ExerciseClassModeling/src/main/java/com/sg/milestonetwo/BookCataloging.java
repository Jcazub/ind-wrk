/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.milestonetwo;

/**
 *
 * @author Jesse
 */
public class BookCataloging {
    private String bookName, authorName, genre, description, publishDate;
    private boolean isCheckedOut;
    private int numberOfPages, publishYear, edition, idNumber;

    public BookCataloging(String bookName, String authorName, String genre, String description, String publishDate, int numberOfPages, int publishYear, int edition, int idNumber) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.genre = genre;
        this.description = description;
        this.publishDate = publishDate;
        this.numberOfPages = numberOfPages;
        this.publishYear = publishYear;
        this.edition = edition;
        this.idNumber = idNumber;
    }
    
    public void checkOutBook() {
        if (!isCheckedOut) {
            System.out.println("You have successfully checked out " + bookName + ".");
            isCheckedOut = true;
        } else {
            System.out.println(bookName + " is already checked out.");
        }
    }
    
    public void returnBook() {
        if (isCheckedOut) {
            System.out.println("Thank you for returning " + bookName);
            isCheckedOut = false;
        } else {
            System.out.println("Error. " + bookName + " is listed as returned already. Please speak with the attending librarian.");
        }
    }
}
