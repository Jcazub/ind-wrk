/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DVDLibrary.dao;

import com.sg.DVDLibrary.dto.DVD;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jesse
 */
public interface DVDLibraryLambdaDao {
    
    DVD addDVD(String title, DVD dvdToAdd) throws DVDLibraryDaoException;
    
    DVD removeDVD(String title) throws DVDLibraryDaoException;
    
    DVD editDVD(String title, DVD dvdToEdit) throws DVDLibraryDaoException;
    
    DVD findDVD(String title) throws DVDLibraryDaoException;
    
    List findAllDVDs() throws DVDLibraryDaoException;
    
    List<DVD> findAllDVDsReleasedInLastNYears (int n) throws DVDLibraryDaoException;
    
    List<DVD> findAllDVDsWithGivenMpaa (String mpaaRating) throws DVDLibraryDaoException;
       
    // Sort by mppaa rating, refer to instructions
    Map<String, List<DVD>> findAllMoviesByGivenDirector (String director) throws DVDLibraryDaoException;
    
    List<DVD> findAllMoviesByGivenStudio (String studio) throws DVDLibraryDaoException;
    
    double findAverageMovieAge() throws DVDLibraryDaoException;
    
    DVD newestMovie() throws DVDLibraryDaoException;
    
    DVD oldestMovie() throws DVDLibraryDaoException;
    
    double averageNumberOfMovieNotes() throws DVDLibraryDaoException;
    
}
