/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DVDLibrary.controller;

import com.sg.DVDLibrary.dao.DVDLibraryDao;
import com.sg.DVDLibrary.dao.DVDLibraryDaoException;
import com.sg.DVDLibrary.dto.DVD;
import com.sg.DVDLibrary.ui.DVDLibraryView;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jesse
 */
public class DVDLibraryController {
    
    DVDLibraryView view;
    DVDLibraryDao dao;
    
    public DVDLibraryController(DVDLibraryView view, DVDLibraryDao dao) {
        this.view = view;
        this.dao = dao;
    }
    
    //Main code ran in app
    public void run() {
        
        int selection = 0;
        boolean keepGoing = true;
        
        try {
            
        while (keepGoing) {
            
            selection = menuSelection();
            
            switch (selection) {
                case 1:
                    addDvd();
                    break;
                case 2:
                    removeDvd();
                    break;
                case 3:
                    editDvd();
                    break;
                case 4:
                    editMultipleDVDs();
                    break;
                case 5:
                    findDvd();
                    break;
                case 6:
                    listDVDsByReleaseDate();
                    break;
                case 7:
                    listDVDsByRating();
                    break;
                case 8:
                    listDVDbyDirector();
                    break;
                case 9:
                    listDVDsByStudio();
                    break;
                case 10:
                    findAverageMovieAge();
                    break;
                case 11:
                    findNewestMovieAdded();
                    break;
                case 12:
                    findOldestMovieAdded();
                    break;
                case 13:
                    averageNumberOfNotes();
                    break;
                case 14:
                    listAllDvds();
                    break;
                case 15:
                    keepGoing = false;
                    break;
                default:
                    view.unknownCommand();
            }
        }
        view.exitMessage();
        } catch (DVDLibraryDaoException e) {
            view.errorMessage(e.getMessage());
        }
        
    }
    
    //Primary Method definitions
    private int menuSelection() {
        return view.getMenuSelection();
    }
    
    private void addDvd() throws DVDLibraryDaoException{
        DVD newDvd;
        
        view.addDVDBanner();
        newDvd = view.getNewDVD();
        dao.addDVD(newDvd.getTitle(), newDvd);
        view.addDVDBannerSuccess();
        
    }
    
    private void removeDvd() throws DVDLibraryDaoException{
        String title;
        
        view.removeDVDBanner();
        title = view.getDVD();
        
        
        if (view.verify("delete", "this")) {
            dao.removeDVD(title);
            view.removeDVDBannerSuccess();
        } else {
            view.removeDVDBannerAborted();
        }

    }
    
    private void editDvd() throws DVDLibraryDaoException{
        String title;
        DVD dvdToEdit;
        
        view.editDVDBanner();
        title = view.getDVD();
        
        dvdToEdit = dao.findDVD(title);
        view.displayDVD(dvdToEdit);
        
        if (view.verify("edit", "this")) {
            DVD editedDvd;

            editedDvd = view.getDVDEditChoices(dvdToEdit);
            dao.editDVD(editedDvd.getTitle(), editedDvd);
            view.editDVDBannerSuccess();
        } else {
            view.editDVDBannerAborted();
        }
       
    }
    
    private void editMultipleDVDs() throws DVDLibraryDaoException{
        String editAnother;
        
        do {
            editDvd();
        } while(view.verify("edit", "another"));
        
        view.editMultipleDVDBannerFinish();
    }
    
    private void findDvd() throws DVDLibraryDaoException{
        
        String title;
        DVD foundDVD;
        
        view.findDVDBanner();
        title = view.getDVD();
        foundDVD = dao.findDVD(title);
        view.displayDVD(foundDVD);
        view.pressEnterToContinue();
       
    }
    
    private void listDVDsByReleaseDate() throws DVDLibraryDaoException{
        int releaseDate;
        List<DVD> dvdList;
        
        releaseDate = view.getReleaseDateYear();
        
        dvdList = dao.findAllDVDsReleasedInLastNYears(releaseDate);
        
        view.listDVDsByReleaseDateBanner(releaseDate);
        for (DVD currentDvd : dvdList) {
            view.displayDVD(currentDvd);
        }
        
        view.pressEnterToContinue();
    }
    
    private void listDVDsByRating() throws DVDLibraryDaoException{
        String mpaaRating;
        List<DVD> dvdList;
        
        mpaaRating = view.getMpaaRating();
        
        dvdList = dao.findAllDVDsWithGivenMpaa(mpaaRating);
        
        view.listDVDsByMpaaRatingBanner(mpaaRating);
        for (DVD currentDvd : dvdList) {
            view.displayDVD(currentDvd);
        }
        
        view.pressEnterToContinue();
    }
    
    private void listDVDbyDirector() throws DVDLibraryDaoException{
        String director, mpaaRating;
        Map<String, List<DVD>> dvdListMap;
        List<DVD> dvdList;
        
        director = view.getDirector();
        mpaaRating = view.getMpaaRating();
        
        dvdListMap = dao.findAllMoviesByGivenDirector(director);
        dvdList = dvdListMap.get(mpaaRating);
        
        view.listDVDsByDirectorBanner(director, mpaaRating);
        for (DVD currentDvd : dvdList) {
            view.displayDVD(currentDvd);
        }
        
        view.pressEnterToContinue();
    }
    
    private void listDVDsByStudio() throws DVDLibraryDaoException{
        String studio;
        List<DVD> dvdList;
        
        studio = view.getStudio();
        
        dvdList = dao.findAllMoviesByGivenStudio(studio);
        
        view.listDVDsByStudioBanner(studio);
        for (DVD currentDvd : dvdList) {
            view.displayDVD(currentDvd);
        }
        
        view.pressEnterToContinue();
    }
    
    private void findAverageMovieAge() throws DVDLibraryDaoException{
        view.displayAverageMovieAge(dao.findAverageMovieAge());
        view.pressEnterToContinue();
    }
    
    private void findNewestMovieAdded() throws DVDLibraryDaoException{
        DVD newestMovie = dao.newestMovie();
        
        view.displayNewestMovieBanner();
        view.displayDVD(newestMovie);
        view.pressEnterToContinue();
    }
    
    private void findOldestMovieAdded() throws DVDLibraryDaoException{
        DVD oldestMovie = dao.oldestMovie();
        
        view.displayOldestMovieBanner();
        view.displayDVD(oldestMovie);
        view.pressEnterToContinue();
    }
    
    private void averageNumberOfNotes() throws DVDLibraryDaoException{
        view.displayAverageNumberOfNotes(dao.averageNumberOfMovieNotes());
        view.pressEnterToContinue();
    }
            
    private void listAllDvds() throws DVDLibraryDaoException{
        List<DVD> allDvds;
        
        view.listAllDVDsBanner();
        allDvds = dao.findAllDVDs();
        for (DVD currentDvd : allDvds) {
            view.displayDVD(currentDvd);
        }
        
        view.pressEnterToContinue();
    }
    
    
    
}

