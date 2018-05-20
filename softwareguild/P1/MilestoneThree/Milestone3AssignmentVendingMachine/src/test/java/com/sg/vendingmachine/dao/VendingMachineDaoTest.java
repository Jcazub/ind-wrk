/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendingItem;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jesse
 */
public class VendingMachineDaoTest {
    
    VendingMachineDao dao = new VendingMachineDaoFileImpl();
    
    public VendingMachineDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        
        List<VendingItem> testInventory = dao.getAllItemsInInventory();
        
        for (VendingItem testItem : testInventory) {
            dao.removeItemFromInventory(testItem.getName());
        }
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addItemToInventory method, of class VendingMachineDao.
     */
    @Test
    public void testAddAndRetrieveItemToInventory() throws Exception {
        VendingItem testItem = new VendingItem("licorice");
        testItem.setInventory(10);
        testItem.setPrice(new BigDecimal(1));
        
        dao.addItemToInventory(testItem.getName(), testItem);
        
        VendingItem daoItem = dao.getItemFromInventory(testItem.getName());
        
        assertEquals(testItem, daoItem);
    }

    /**
     * Test of removeItemFromInventory method, of class VendingMachineDao.
     */
    @Test
    public void testRemoveItemFromInventory() throws Exception {
        VendingItem testItem = new VendingItem("licorice");
        testItem.setInventory(10);
        testItem.setPrice(new BigDecimal(1));
        
        dao.addItemToInventory(testItem.getName(), testItem);
        
        VendingItem daoItem = dao.removeItemFromInventory(testItem.getName());
        
        assertEquals(testItem, daoItem);
    }

    /**
     * Test of editItemInInventory method, of class VendingMachineDao.
     */
    @Test
    public void testEditItemInInventory() throws Exception {
        VendingItem testItem = new VendingItem("licorice");
        testItem.setInventory(10);
        testItem.setPrice(new BigDecimal(1));
        
        dao.editItemInInventory(testItem.getName(), testItem);
        
        VendingItem daoItem = dao.getItemFromInventory(testItem.getName());
        
        assertEquals(testItem, daoItem);
    }

    /**
     * Test of getAllItemsInInventory method, of class VendingMachineDao.
     */
    @Test
    public void testGetAllItemsInInventory() throws Exception {
        VendingItem testItem = new VendingItem("licorice");
        testItem.setInventory(10);
        testItem.setPrice(new BigDecimal("1"));
        
        dao.addItemToInventory(testItem.getName(), testItem);
        
        VendingItem testItem1 = new VendingItem("chocolate");
        testItem1.setInventory(5);
        testItem1.setPrice(new BigDecimal("1"));

        dao.addItemToInventory(testItem1.getName(), testItem1);


        assertEquals(2, (int) dao.getAllItemsInInventory().size());
    }

    /**
     * Test of getItemsInStock method, of class VendingMachineDao.
     */
    @Test
    public void testGetItemsInStock() throws Exception {
        VendingItem testItem = new VendingItem("licorice");
        testItem.setInventory(10);
        testItem.setPrice(new BigDecimal("1"));
        
        dao.addItemToInventory(testItem.getName(), testItem);
        
        VendingItem testItem1 = new VendingItem("chocolate");
        testItem1.setInventory(0);
        testItem1.setPrice(new BigDecimal("1"));

        dao.addItemToInventory(testItem1.getName(), testItem1);

        assertEquals(1, (int) dao.getItemsInStock().size());
        
    }

    
    
}
