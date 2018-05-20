/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class AddressBookDaoFileImpl implements AddressBookDao {
    
    Map<String, Address> AddressBook = new HashMap<>();
    public static final String ADDRESS_BOOK = "address_book.txt";
    public static final String DELIMITER = "::";

    @Override
    public Address addAddress(String lastName, Address address) throws AddressBookDaoException {
        Address newAddress = AddressBook.put(lastName, address);
        writeToAddressBookRecord();
        return newAddress;
    }

    @Override
    public Address deleteAddress(String lastName) throws AddressBookDaoException {
        Address deletedAddress = AddressBook.remove(lastName);
        writeToAddressBookRecord();
        return deletedAddress;
    }

    @Override
    public Address findAddress(String lastName) throws AddressBookDaoException {
        loadAddressBook();
        Address foundAddress = AddressBook.get(lastName);
        return foundAddress;
    }

    @Override
    public Integer listAddressCount() throws AddressBookDaoException {
        int addressCount = 0;
        loadAddressBook();
        List<Address> addresses = listAddresses();
        for ( Address currentAddress : addresses ) {
            addressCount++;
        }
        return addressCount;
    }

    @Override
    public List<Address> listAddresses() throws AddressBookDaoException {
        loadAddressBook();
        return new ArrayList<Address>(AddressBook.values());
    }
    
    public void loadAddressBook() throws AddressBookDaoException {
        Scanner scanner;
        
        //need error catching here
        try {
            scanner = new Scanner( new BufferedReader ( new FileReader(ADDRESS_BOOK)));
        } catch (FileNotFoundException e) {
            throw new AddressBookDaoException("Could not load addres book data from memory", e);
        }
        
        
        String currentLine;
        String[] currentTokens;
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Address currentAddress = new Address(currentTokens[0], currentTokens[1]);
            currentAddress.setStreet(currentTokens[2]);
            currentAddress.setCity(currentTokens[3]);
            currentAddress.setState(currentTokens[4]);
            currentAddress.setZipCode(Integer.parseInt(currentTokens[5]));
            
            AddressBook.put(currentAddress.getLastName(), currentAddress);
        }       
        scanner.close();
    }
    
    public void writeToAddressBookRecord() throws AddressBookDaoException {
        
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(ADDRESS_BOOK));
        } catch (IOException e) {
            throw new AddressBookDaoException("Could not save Address Book data", e);
        }
        
        
        List<Address> addressBookListings = this.listAddresses();
        
        for (Address address : addressBookListings) {
            out.println(address.getLastName() + DELIMITER + address.getFirstName() 
                    + DELIMITER + address.getStreet() + DELIMITER 
                    + address.getCity() + DELIMITER
                    + address.getState() + DELIMITER + address.getZipCode());  
            out.flush();
        }
        out.close();
     
    }
    
}
