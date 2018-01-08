/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DVDLibrary.ui;

import com.sg.DVDLibrary.dto.DVD;

/**
 *
 * @author Jesse
 */
public class DVDLibraryView {
    private UserIO io;
    
    public DVDLibraryView(UserIO io) {
        this.io = io;
    }
    
    public int getMenuSelection() {
        
        io.print("Main Menu");
        io.print("     What would you like to do?");
        io.print("              1. Add a DVD");
        io.print("              2. Remove a DVD");
        io.print("              3. Edit a DVD");
        io.print("              4. Edit Multiple DVDs");
        io.print("              5. Find a DVD");
        io.print("              6. Find movies by age");
        io.print("              7. Find movies by MPAA Rating");
        io.print("              8. Find movies by Director (sorted by MPAA Rating)");
        io.print("              9. Find movies by studio");
        io.print("              10. Find out the average age of a movie in the DVD library");
        io.print("              11. Find the newest movie added to the DVD library");
        io.print("              12. Find the oldest movie in the DVD library");
        io.print("              13. Find out the average word count for all DVD notes");      
        io.print("              14. List all DVDs");
        io.print("              15. Exit");
        return io.readInt("Enter a number (1-16) corresponding to your selection: ", 1, 15);

    }
    
    public DVD getNewDVD() {
        DVD newDvd;
        
        io.print("Enter the details for the DVD below: ");
        String title = io.readString("Title: ");
        String directorName = io.readString("Director: ");
        String studio = io.readString("Studio: ");
        String releaseDate = io.readString("Release Date (yyyy-MM-dd i.e. 2017-01-01): ");
        String mpaaRating = io.readString("MPAA Rating: ");
        String additionalNotes = io.readString("Additional notes: ");
        
        newDvd = new DVD(title);
        
        newDvd.setDirectorName(directorName);
        newDvd.setStudio(studio);
        newDvd.setReleaseDate(releaseDate);
        newDvd.setMpaaRating(mpaaRating);
        newDvd.setAdditionalNote(additionalNotes);
        
        return newDvd;
    }
    
    public void addDVDBanner() {
        io.print("===== Adding DVD to Library =====");       
    }
    
    public void addDVDBannerSuccess() {
        io.print("Added DVD successfully");
        this.pressEnterToContinue();
    }
    
    public void pressEnterToContinue() {
        io.print("");
        io.readString("Press Enter to continue");
    }
    
    public String getDVD() {
        return io.readString("Enter the title of the DVD: ");
    }
    
    public int getReleaseDateYear() {
        return io.readInt("Enter the maximum age of the movies you want to list: ");
    }
    
    public String getDirector() {
        return io.readString("Enter a director (DVDs with a corresponding MPAA Rating for this director will be listed): ");
    }
    
    public String getMpaaRating() {
        return io.readString("Enter a MPAA Rating (DVDs with that rating will be listed):");
    }
    
    public String getStudio() {
        return io.readString("Enter a studio (DVDs by this studio will be listed): ");
    }
    
    public void removeDVDBanner() {
        io.print("===== Removing DVD from Library =====");
    }
    
    public void removeDVDBannerSuccess() {
        io.print("===== Removed DVD successfully");
        this.pressEnterToContinue();
    }
    
    public void removeDVDBannerAborted() {
        io.print("===== DVD Removal Aborted =====");
        this.pressEnterToContinue();
    }
    public boolean verify(String choice1, String choice2) {
        String verification;
        
        do {
        verification = io.readString(choice1 + " " + choice2 + " DVD? (y/n): ");
        } while(!(verification.equalsIgnoreCase("y") || verification.equalsIgnoreCase("n")));
        
        return verification.equalsIgnoreCase("y");
    }
    
    public void editDVDBanner() {
        io.print("===== Editing DVD in Library =====");
    }
    
    public DVD getDVDEditChoices(DVD dvdToEdit) {
 
        Boolean keepGoing = true;
        
        do {
            io.print("     Which field would you like to edit?");
            io.print("              1. Director Name");
            io.print("              2. Studio");
            io.print("              3. Release Date");
            io.print("              4. MPAA Rating");
            io.print("              5. Additional notes");
            int editChoice = io.readInt("Choice: ",1,5);
        
            switch (editChoice) {
            
            case 1: 
                dvdToEdit.setDirectorName(io.readString("Director Name: "));
                break;
            case 2:
                dvdToEdit.setStudio(io.readString("Studio: "));
                break;
            case 3:
                dvdToEdit.setReleaseDate(io.readString("Release Date: "));
                break;
            case 4:
                dvdToEdit.setMpaaRating(io.readString("MPAA Rating: "));
                break;
            case 5:
                dvdToEdit.setAdditionalNote(io.readString("Additional notes: "));
                break;
            default:
                this.unknownCommand();
            } 
            
            String another = io.readString("Edit another field? (y/n): ");
            
            if(!another.equalsIgnoreCase("y")) {
                keepGoing = false;
            }
        } while (keepGoing);
        
        
        return dvdToEdit;
    }
    
    public void editDVDBannerSuccess() {
        io.print("===== DVD edited successfully =====");
        this.pressEnterToContinue();
    }
    
    public void editDVDBannerAborted() {
        io.print("===== DVD Editing Aborted =====");
        this.pressEnterToContinue();
    }
    
    public void editMultipleDVDBannerFinish() {
        io.print("===== Finished editing DVDs =====");
    }
    
    public void displayDVD(DVD dvdToDisplay) {
        io.print("");
        io.print(dvdToDisplay.getTitle());
        io.print(dvdToDisplay.getDirectorName());
        io.print(dvdToDisplay.getStudio());
        io.print(String.valueOf(dvdToDisplay.getReleaseDate()));
        io.print(dvdToDisplay.getMpaaRating());
        io.print(dvdToDisplay.getAdditionalNote());
        io.print("");
    }
    
    public void findDVDBanner() {
        io.print("Looking for DVD in Library...");
    }
    
    public void listAllDVDsBanner() {
        io.print("Listing All DVDs in Library...");
    }
    
    public void errorMessage(String errMsg) {
        io.print("===== ERROR =====");
        io.print(errMsg);
    }
    
    public void unknownCommand() {
        io.print("===== Unknown Command =====");
    }
    
    public void exitMessage() {
        io.print("Exiting Library...");
    }
    
    public void listDVDsByReleaseDateBanner(int releaseDate) {
        io.print("Listing All movies released " + releaseDate + " years ago...");
    }
    
    public void listDVDsByMpaaRatingBanner(String mpaaRating) {
        io.print("Listing All movies with the MPAA Rating " + mpaaRating + "...");
    }
    
    public void listDVDsByDirectorBanner(String director, String mpaaRating) {
        io.print("Listing All movies by " + director + " with the MPAA Rating: " + mpaaRating + "...");
    }
    
    public void listDVDsByStudioBanner(String studio) {
        io.print("Listing All movies by " + studio + "...");
    }
    
    public void displayAverageMovieAge(double age) {
        io.print("The average age of a movie in this library is " + age + ".");
    }
    
    public void displayNewestMovieBanner() {
        io.print("===== Most Recently Released Movie found in library =====");
    }
    
    public void displayOldestMovieBanner() {
        io.print("===== Oldest Released Movie found in library =====");
    }
    
    public void displayAverageNumberOfNotes(double averageNumberOfNotes) {
        io.print("The average number of words written in a DVD's notes is " + averageNumberOfNotes + ".");
    }
    
}
