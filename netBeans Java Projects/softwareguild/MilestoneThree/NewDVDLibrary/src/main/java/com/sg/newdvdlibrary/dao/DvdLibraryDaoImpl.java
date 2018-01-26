/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.newdvdlibrary.dao;

import com.sg.newdvdlibrary.dto.Dvd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DvdLibraryDaoImpl implements DvdLibraryDao {

    private Map<String, Dvd> DvdLibrary = new HashMap<>();
    
    @Override
    public Dvd addDvd(String title, Dvd addedDvd) {
        Dvd newDvd = DvdLibrary.put(title, addedDvd);
        return newDvd;
    }

    @Override
    public Dvd removeDvd(String title) {
        Dvd removedDvd = DvdLibrary.remove(title);
        return removedDvd;
    }

    @Override
    public Dvd editDvd(String title, Dvd dvdToEdit) {
        DvdLibrary.remove(title);
        Dvd editedDvd = DvdLibrary.put(dvdToEdit.getTitle(), dvdToEdit);
        return editedDvd;
    }

    @Override
    public List<Dvd> listDvds() {
        return new ArrayList<Dvd>(DvdLibrary.values());
    }

    @Override
    public Dvd getDvd(String title) {
        return DvdLibrary.get(title);
    }
    
}
