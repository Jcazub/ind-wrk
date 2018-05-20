/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DVDLibrary.dao;

import com.sg.DVDLibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author Jesse
 */
public interface DVDLibraryDao {
    
    DVD addDVD(String title, DVD dvdToAdd) throws DVDLibraryDaoException;
    
    DVD removeDVD(String title) throws DVDLibraryDaoException;
    
    DVD editDVD(String title, DVD dvdToEdit) throws DVDLibraryDaoException;
    
    DVD findDVD(String title) throws DVDLibraryDaoException;
    
    List findAllDVDs() throws DVDLibraryDaoException;

}
