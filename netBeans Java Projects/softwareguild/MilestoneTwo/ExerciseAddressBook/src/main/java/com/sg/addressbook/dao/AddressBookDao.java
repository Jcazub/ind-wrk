/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;

/**
 *
 * @author Jesse
 */
public interface AddressBookDao {
    
    void addAddress();
    
    Address removeAddress(String lastName);
    
    Address findAddress(String lastName);
    
    public void listAddressCount(Address address);
    
    public void listAddresses();
            
            
}
