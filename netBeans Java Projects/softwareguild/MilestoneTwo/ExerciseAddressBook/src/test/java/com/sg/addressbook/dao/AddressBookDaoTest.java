/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jesse
 */
public class AddressBookDaoTest {
    
    private AddressBookDao dao = new AddressBookDaoFileImpl();
    
    public AddressBookDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List<Address> addressBook = dao.listAddresses();
        
        for (Address address : addressBook) {
            dao.deleteAddress(address.getLastName());
        }
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addAddress method, of class AddressBookDao.
     */
    @Test
    public void testAddAndFindAddress() throws Exception {
        Address testAddress = new Address("Azubuike", "Jesse");
        testAddress.setStreet("31-10 Thomson Ave");
        testAddress.setCity("Long Island City");
        testAddress.setState("New York");
        testAddress.setZipCode(11101);
        
        dao.addAddress(testAddress.getLastName(), testAddress);
        
        Address daoAddress = dao.findAddress("Azubuike");
        
        assertEquals(testAddress, daoAddress);
        
    }

    /**
     * Test of deleteAddress method, of class AddressBookDao.
     */
    @Test
    public void testDeleteAddress() throws Exception {
        Address testAddress = new Address("Azubuike", "Jesse");
        testAddress.setStreet("31-10 Thomson Ave");
        testAddress.setCity("Long Island City");
        testAddress.setState("New York");
        testAddress.setZipCode(11101);
        
        dao.addAddress(testAddress.getLastName(), testAddress);
        
        assertEquals(1, (int) dao.listAddressCount());
        
        Address daoAddress = dao.deleteAddress("Azubuike");
        
        assertEquals(testAddress, daoAddress);
        
        assertEquals(0, (int) dao.listAddressCount());
        
    }

    /**
     * Test of listAddressCount method, of class AddressBookDao.
     */
    @Test
    public void testListAddressCount() throws Exception {
        Address testAddress = new Address("Azubuike", "Jesse");
        testAddress.setStreet("31-10 Thomson Ave");
        testAddress.setCity("Long Island City");
        testAddress.setState("New York");
        testAddress.setZipCode(11101);
        
        dao.addAddress(testAddress.getLastName(), testAddress);
        
        Address testAddress2 = new Address("Obama", "Barack");
        testAddress2.setStreet("1600 Pennsylvania Avenue NW");
        testAddress2.setCity("Washington");
        testAddress2.setState("DC");
        testAddress2.setZipCode(20500);
        
        dao.addAddress(testAddress2.getLastName(), testAddress2);
        
        
        assertEquals(2, (int) dao.listAddressCount());
        
    }

    /**
     * Test of listAddresses method, of class AddressBookDao.
     */
    @Test
    public void testListAddresses() throws Exception {
        Address testAddress = new Address("Azubuike", "Jesse");
        testAddress.setStreet("31-10 Thomson Ave");
        testAddress.setCity("Long Island City");
        testAddress.setState("New York");
        testAddress.setZipCode(11101);
        
        dao.addAddress(testAddress.getLastName(), testAddress);
        
        Address testAddress2 = new Address("Obama", "Barack");
        testAddress2.setStreet("1600 Pennsylvania Avenue NW");
        testAddress2.setCity("Washington");
        testAddress2.setState("DC");
        testAddress2.setZipCode(20500);
        
        dao.addAddress(testAddress2.getLastName(), testAddress2);
        
        
        List<Address> testAddressList = new ArrayList<>();
        
        testAddressList.add(testAddress); 
        testAddressList.add(testAddress2);
        
        
        
        assertEquals(2, dao.listAddresses().size());
        assertEquals(testAddressList, dao.listAddresses());
    }

}
