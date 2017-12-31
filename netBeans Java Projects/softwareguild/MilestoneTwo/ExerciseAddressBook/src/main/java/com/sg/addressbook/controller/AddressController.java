/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookDao;
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
                    listAddressCount();
                    break;
                case 5:
                    listAllAddresses();
                    break;
                case 6:
                    keepgoing = false;
                    break;
                default:
                    view.displayUnknownCommand();
            }        
        }
        view.displayExit();
    }
    
    private void addNewAddress() {
        view.displayCreateNewAddress();
        Address newAddress = view.getNewAddress();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.displayNewAddressAddedSuccess();
        view.displayContinue();
    }
    
    private void deleteAddress() {
        view.displayDeletingAddress();
        String deletedAddressChoice = view.getAddress("delete");
        dao.deleteAddress(deletedAddressChoice);
        view.displayDeletedAddressSuccess();
        view.displayContinue();
    }
    
    private void findAddress() {
        view.displayFindingAddress();
        String FindAddressChoice = view.getAddress("find");
        Address foundAddress = dao.findAddress(FindAddressChoice);
        view.displayAddress(foundAddress);
        view.displayContinue();
    }
    
    private void listAddressCount() {
        view.displayListingAddressCount();
        int addressCount = dao.listAddressCount();
        view.displayAddressCount(addressCount);
        view.displayContinue();
    }
    
    private void listAllAddresses() {
        view.displayListingAllAddresses();
        List<Address> allAddresses = dao.listAddresses();
        view.displayAllAddresses(allAddresses);
        view.displayContinue();
    }
    
}
