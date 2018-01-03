/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.ui;

import com.sg.addressbook.dto.Address;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        io.print("Main Menu: ");
        io.print("     Please select the operation you wish to perform:");
        io.print("           1. Add Address");
        io.print("           2. Delete Address");
        io.print("           3. Find Address");
        io.print("           4. Edit Address");
        io.print("           5. List Adress Count");
        io.print("           6. List All Addresses");
        io.print("           7. Exit");

        return io.readInt("Selection?: ", 1, 7);
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
                + " to " + choice + ".");
    }
    
    public void displayAddress(Address address) {
        if (address != null){
            io.print("");
            io.print(address.getFirstName() + " " + address.getLastName());
            io.print(address.getStreet());
            io.print(address.getCity() + ", " + address.getState() + ", " + address.getZipCode());
            io.print("");
        } else {
            io.print("Address not found");
        }
        
    }
    
    public Address editAddress(Address address) {
        Address editedAddress = address;
        editedAddress.setStreet(io.readString("Please Enter Street Address: "));
        editedAddress.setCity(io.readString("Please Enter City Location: "));
        editedAddress.setState(io.readString("Please Enter State Location: "));
        editedAddress.setZipCode(io.readInt("Please Enter Zipcode: "));
        return editedAddress;
    }
    
    public boolean verify(String choice) {
        String verify;
        do {
            verify = io.readString("Are you sure you want to " + choice + " this address? (y/n): ");
        } while (!(verify.equalsIgnoreCase("y") || verify.equalsIgnoreCase("n")));
        
        return verify.equalsIgnoreCase("y");
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
    
    public void displayDeletedAddressAborted() {
        io.print("===== Address deletion aborted =====");
    }
    
    public void displayFindingAddress() {
        io.print("===== Finding Address =====");
    }
    
    public void displayContinue() {
        io.readString("Press enter to return to main menu");
    }
    
    public void displayListingAddressCount() {
        io.print("Calculating number of addresses in Address Book...");
    }
    
    public void displayListingAllAddresses() {
        io.print("===== Listing all addresses in Address Book =====");
    }
    
    public void displayEditingAddress() {
        io.print("===== Editing an address =====");
    }

    public void displayEditAddressAborted() {
        io.print("===== Address edit Aborted =====");
    }
    
    public void displayEditedAddressSuccess() {
        io.print("===== Address edit successfull =====");
    }
    
    public void displayAllAddresses(List<Address> addresses) {
        for (Address currentAddress : addresses) {
            this.displayAddress(currentAddress);
        }
    }
    
    public void displayUnknownCommand() {
        io.print("Unknown Command");
    }
    
    public void displayExit() {
        io.print("Closing Address Book...");
    }
    
    public void displayErrorMessage(String message) {
        io.print("=== ERROR ===");
        io.print(message);
    }
}
