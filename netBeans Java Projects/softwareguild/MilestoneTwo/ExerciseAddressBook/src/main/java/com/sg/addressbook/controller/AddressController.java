/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookDaoException;
import com.sg.addressbook.dto.Address;
import com.sg.addressbook.ui.AddressBookView;
import java.util.List;

/**
 *
 * @author Jesse
 */
public class AddressController {
    AddressBookDao dao;
    AddressBookView view;
    
    public AddressController(AddressBookDao dao,AddressBookView view) {
        this.dao = dao;
        this.view = view;
    }
    
    public void run() {
        boolean keepgoing = true;
        int menuSelection = 0;
        
        try {
           while (keepgoing) {
            menuSelection = view.printMenuSelection();
            
            switch (menuSelection) {
                case 1:
                    addNewAddress();
                    break;
                case 2:
                    deleteAddress();
                    break;
                case 3:
                    findAddress();
                    break;
                case 4:
                    editAddress();
                    break;
                case 5:
                    listAddressCount();
                    break;
                case 6:
                    listAllAddresses();
                    break;
                case 7:
                    keepgoing = false;
                    break;
                default:
                    view.displayUnknownCommand();
            }        
         }
        view.displayExit(); 
        } catch (AddressBookDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
        
    }
    
    private void addNewAddress() throws AddressBookDaoException {
        view.displayCreateNewAddress();
        Address newAddress = view.getNewAddress();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.displayNewAddressAddedSuccess();
        view.displayContinue();
    }
    
    private void deleteAddress() throws AddressBookDaoException {
        view.displayDeletingAddress();
        String deletedAddressChoice = view.getAddress("delete");
        view.displayAddress(dao.findAddress(deletedAddressChoice));
        boolean verification = view.verify("delete");
        if (verification) {
            dao.deleteAddress(deletedAddressChoice);
        view.displayDeletedAddressSuccess();
        } else {
            view.displayDeletedAddressAborted();
        }
        view.displayContinue();
    }
    
    private void findAddress() throws AddressBookDaoException {
        view.displayFindingAddress();
        String FindAddressChoice = view.getAddress("find");
        Address foundAddress = dao.findAddress(FindAddressChoice);
        view.displayAddress(foundAddress);
        view.displayContinue();
    }
    
    private void editAddress() throws AddressBookDaoException {
        view.displayEditingAddress();
        String editAddressChoice = view.getAddress("edit");
        Address addressToEdit = dao.findAddress(editAddressChoice);
        view.displayAddress(addressToEdit);
        boolean verification = view.verify("edit");
        if (verification) {
            Address editedAddress = view.editAddress(addressToEdit);
            dao.addAddress(editedAddress.getLastName(), editedAddress);
            view.displayEditedAddressSuccess();
        } else {
            view.displayEditAddressAborted();
        }
        view.displayContinue();
    }
    
    private void listAddressCount() throws AddressBookDaoException {
        view.displayListingAddressCount();
        int addressCount = dao.listAddressCount();
        view.displayAddressCount(addressCount);
        view.displayContinue();
    }
    
    private void listAllAddresses() throws AddressBookDaoException{
        view.displayListingAllAddresses();
        List<Address> allAddresses = dao.listAddresses();
        view.displayAllAddresses(allAddresses);
        view.displayContinue();
    }
    
}
