/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.newdvdlibrary.dao;

import com.sg.newdvdlibrary.dto.Dvd;
import java.util.List;


/**
 *
 * @author Jesse
 */
public interface DvdLibraryDao {
    
    Dvd addDvd(String title, Dvd addedDvd);
    
    Dvd removeDvd(String title);
    
    Dvd editDvd(String title, Dvd dvdToEdit);
    
    List<Dvd> listDvds();
    
    Dvd getDvd(String title);
    
}
