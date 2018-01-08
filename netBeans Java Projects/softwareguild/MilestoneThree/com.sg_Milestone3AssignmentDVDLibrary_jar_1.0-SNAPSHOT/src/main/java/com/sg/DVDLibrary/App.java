/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DVDLibrary;

import com.sg.DVDLibrary.controller.DVDLibraryController;
import com.sg.DVDLibrary.dao.DVDLibraryDao;
import com.sg.DVDLibrary.dao.DVDLibraryDaoConsoleImpl;
import com.sg.DVDLibrary.dao.DVDLibraryLambdaDao;
import com.sg.DVDLibrary.dao.DVDLibraryLambdaDaoConsoleImpl;
import com.sg.DVDLibrary.ui.DVDLibraryView;
import com.sg.DVDLibrary.ui.UserIO;
import com.sg.DVDLibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author Jesse
 */
public class App {
    public static void main(String[]args) {
        
        //Dependencies declared and initialized
        UserIO myIo = new UserIOConsoleImpl();
        DVDLibraryDao myDao = new DVDLibraryDaoConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIo);
        DVDLibraryController controller = new DVDLibraryController(myView, myDao);
        
        //Main code run
        controller.run();
        
    }
}
