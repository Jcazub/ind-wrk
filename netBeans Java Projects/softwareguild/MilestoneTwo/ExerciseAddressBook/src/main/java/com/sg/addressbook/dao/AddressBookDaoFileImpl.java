/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jesse
 */
public class AddressBookDaoFileImpl implements AddressBookDao {
    
    Map<String, Address> AddressBook = new HashMap<>();

    @Override
    public Address addAddress(String lastName, Address address) {
        Address newAddress = AddressBook.put(lastName, address);
        return newAddress;
    }

    @Override
    public Address deleteAddress(String lastName) {
        Address deletedAddress = AddressBook.remove(lastName);
        return deletedAddress;
    }

    @Override
    public Address findAddress(String lastName) {
        Address foundAddress = AddressBook.get(lastName);
        return foundAddress;
    }

    @Override
    public Integer listAddressCount() {
        int addressCount = 0;
        List<Address> addresses = listAddresses();
        for ( Address currentAddress : addresses ) {
            addressCount++;
        }
        return addressCount;
    }

    @Override
    public List<Address> listAddresses() {
        return new ArrayList<Address>(AddressBook.values());
    }
    
    
}
