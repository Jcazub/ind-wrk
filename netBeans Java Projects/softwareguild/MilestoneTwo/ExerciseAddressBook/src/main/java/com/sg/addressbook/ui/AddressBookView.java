/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.ui;

import com.sg.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author Jesse
 */
public class AddressBookView {
    private UserIO io;
    
    public AddressBookView(UserIO io) {
        this.io = io;
    }
    
    public int printMenuSelection() {
        
        io.print("=============");
        io.print("Initial Menu: ");
        io.print("     Please select the operation you wish to perform:");
        io.print("           1. Add Address");
        io.print("           2. Delete Address");
        io.print("           3. Find Address");
        io.print("           4. List Adress Count");
        io.print("           5. List All Addresses");
        io.print("           6. Exit");

        return io.readInt("Selection?: ", 1, 6);
    }
    
    public Address getNewAddress() {
        
        String firstName = io.readString("Please Enter First Name: ");
        String lastName = io.readString("Please Enter Last Name: ");
        String street = io.readString("Please Enter Street Address: ");
        String city = io.readString("Please Enter City Location: ");
        String state = io.readString("Please Enter State Location: ");
        int zipCode = io.readInt("Please Enter Zipcode: ");
        
        Address userInputAddress = new Address(lastName, firstName);
        userInputAddress.setStreet(street);
        userInputAddress.setCity(city);
        userInputAddress.setState(state);
        userInputAddress.setZipCode(zipCode);
        
        return userInputAddress;
    }
    
    public String getAddress(String choice) {
        return io.readString("Please enter the last name of the address"
                + " to " + choice);
    }
    
    public void displayAddress(Address address) {
        if (address != null){
            io.print(address.getFirstName() + " " + address.getLastName());
            io.print(address.getStreet());
            io.print(address.getCity() + ", " + address.getState() + ", " + address.getZipCode());
        } else {
            io.print("Address not found");
        }
        
    }
    
    public void displayAddressCount(int addressCount) {
        io.print("There are " + addressCount + " addresses in the Address Book.");
    }
    
    public void displayCreateNewAddress() {
        io.print("===== Creating New Address =====");
    }
    
    public void displayNewAddressAddedSuccess() {
        io.print("===== Address has successfully been added =====");
    }
    
    public void displayDeletingAddress() {
        io.print("===== Deleting Address =====");
    }
    
    public void displayDeletedAddressSuccess() {
        io.print("===== Address deleted successfully =====");
    }
    
    public void displayFindingAddress() {
        io.print("===== Finding Address =====");
    }
    
    public void displayContinue() {
        io.readString("Press any button to return to main menu");
    }
    
    public void displayListingAddressCount() {
        io.print("Calculating number of addresses in Address Book...");
    }
    
    public void displayListingAllAddresses() {
        io.print("===== Listing all addresses in Address Book =====");
    }
    
    public void displayAllAddresses(List<Address> addresses) {
        for (Address currentAddress : addresses) {
            io.print("");
            this.displayAddress(currentAddress);
            io.print("");
        }
    }
    
    public void displayUnknownCommand() {
        io.print("Unknown Command");
    }
    
    public void displayExit() {
        io.print("Closing Address Book...");
    }
}
