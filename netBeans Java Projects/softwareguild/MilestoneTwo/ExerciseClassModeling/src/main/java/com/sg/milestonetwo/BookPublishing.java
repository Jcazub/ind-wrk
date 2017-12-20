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
public class BookPublishing {
    private String bookTitle, summary, audience, genre, publishDate;
    private int authorID, daysTillFinished;
    private boolean isPublishReady, isReviewReady;

    public BookPublishing(String bookTitle, String summary, String audience, String genre, int authorID) {
        this.bookTitle = bookTitle;
        this.summary = summary;
        this.audience = audience;
        this.genre = genre;
        this.authorID = authorID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getSummary() {
        return summary;
    }

    public String getAudience() {
        return audience;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public int getAuthorID() {
        return authorID;
    }

    public int getDaysTillFinished() {
        return daysTillFinished;
    }

    public boolean isIsPublishReady() {
        String currentDate = "";
        // find a way to set currentDate
        setPublishDate(currentDate);
        return isPublishReady;
    }

    public boolean isIsReviewReady() {
        return isReviewReady;
    }

    private void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public void setDaysTillFinished(int daysTillFinished) {
        this.daysTillFinished = daysTillFinished;
    }

    public void setIsPublishReady(boolean isPublishReady) {
        this.isPublishReady = isPublishReady;
    }

    public void setIsReviewReady(boolean isReviewReady) {
        this.isReviewReady = isReviewReady;
    }
    
    public void saveProgress() {
        // saves progress made on book
    }
}
