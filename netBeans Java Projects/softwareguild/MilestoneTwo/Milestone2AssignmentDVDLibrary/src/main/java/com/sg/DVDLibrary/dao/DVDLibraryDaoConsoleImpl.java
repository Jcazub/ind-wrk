/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DVDLibrary.dao;

import com.sg.DVDLibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Jesse
 */
public class DVDLibraryDaoConsoleImpl implements DVDLibraryDao {
    
    Map<String, DVD> DVDLibrary = new HashMap<>();
    private static final String DVDLibrary_FILE = "DVDLibrary.txt";
    private static final String DELIMITER = "::";

    @Override
    public DVD addDVD(String title, DVD dvdToAdd) throws DVDLibraryDaoException {
        DVD addedDvd = DVDLibrary.put(title, dvdToAdd);
        writeToLibrary();
        return addedDvd;
       
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoException {
        DVD removedDvd = DVDLibrary.remove(title);
        writeToLibrary();
        return removedDvd;
    }
    
    @Override
    public DVD editDVD(String title, DVD dvdToEdit) throws DVDLibraryDaoException {
        DVD editedDvd = DVDLibrary.put(title, dvdToEdit);
        writeToLibrary();
        return editedDvd;
    }

    @Override
    public DVD findDVD(String title) throws DVDLibraryDaoException {
        loadLibrary();
        return DVDLibrary.get(title);
    }

    @Override
    public List findAllDVDs() throws DVDLibraryDaoException {
        loadLibrary();
        return new ArrayList<DVD>(DVDLibrary.values());
    }
    
    public void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;
        String currentLine;
        String[] currentTokens;
        
        
        try {
            scanner = new Scanner(new BufferedReader (new FileReader(DVDLibrary_FILE)));
        } catch (FileNotFoundException e) {
            //Encapulates error catching to hide implementation
            throw new DVDLibraryDaoException("Could not read DVD Library", e);
        }

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            DVD readDvd = new DVD(currentTokens[0]);
            
            readDvd.setDirectorName(currentTokens[1]);
            readDvd.setStudio(currentTokens[2]);
            readDvd.setReleaseDate(currentTokens[3]);
            readDvd.setMpaaRating(currentTokens[4]);
            readDvd.setAdditionalNote(currentTokens[5]);
            
            DVDLibrary.put(readDvd.getTitle(), readDvd);
        }
        
        scanner.close();
        
    }
    
    public void writeToLibrary() throws DVDLibraryDaoException {
        PrintWriter out;
        
        try {
            out = new PrintWriter( new FileWriter(DVDLibrary_FILE));
        } catch (IOException e) {
            //Encapulates error catching to hide implementation
            throw new DVDLibraryDaoException("Cound not write to DVD Library", e);
        }
        
        List<DVD> allDvds = findAllDVDs();
        
        for (DVD currentDvd : allDvds) {
            out.println(currentDvd.getTitle() + DELIMITER
                + currentDvd.getDirectorName() + DELIMITER
                + currentDvd.getStudio() + DELIMITER
                + currentDvd.getReleaseDate() + DELIMITER
                + currentDvd.getMpaaRating() + DELIMITER
                + currentDvd.getAdditionalNote());
            out.flush();
        }
        out.close();    
    }
            
}
