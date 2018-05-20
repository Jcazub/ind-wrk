/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoStubImpl;
import com.sg.vendingmachine.dto.VendingItem;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jesse
 */
public class VendingMachineServiceLayerTest {
    
    private VendingMachineServiceLayer service;
    
    public VendingMachineServiceLayerTest() {
        
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        
        service = new VendingMachineServiceLayerImpl(dao);
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addItemToInventory method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testAddItemToInventorySuccessful() throws Exception {
        VendingItem testItem = new VendingItem("chocolate");
        testItem.setPrice(new BigDecimal(2));
        testItem.setInventory(20);
        VendingItem addedItem = service.addItemToInventory(testItem.getName(), testItem);
        assertEquals(testItem.getName(), addedItem.getName());
    }
    
    @Test
    public void testAddItemToInventoryItemInInventory() throws Exception {
        VendingItem testItem = new VendingItem("licorice");
        testItem.setPrice(new BigDecimal(2));
        testItem.setInventory(20);
        
        try {
            service.addItemToInventory(testItem.getName(), testItem);
            fail("Expected ItemAlreadyInInventoryException");
        } catch (ItemAlreadyInInventoryException e) {
            return;
        }
        
    }
    
     @Test
    public void testAddItemToInventoryDataValidation() throws Exception {
        VendingItem testItem = new VendingItem("chocolate");
        testItem.setPrice(new BigDecimal(2));
        testItem.setInventory(0);
        
        try {
            service.addItemToInventory(testItem.getName(), testItem);
            fail("Expected VendingMachineDataValidationException");
        } catch (VendingMachineDataValidationException e) {
            return;
        }
        
    }

    /**
     * Test of removeItemFromInventory method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testRemoveItemFromInventory() throws Exception {
        VendingItem removedItem = service.removeItemFromInventory("licorice");
        assertNotNull(removedItem);
        
    }
    
    @Test
    public void testRemoveItemFromInventoryNoneFound() throws Exception {
        
        try {
            VendingItem removedItem = service.removeItemFromInventory("reese's");
            fail("Expected NoItemInInventoryException");
        } catch (NoItemInInventoryException e) {
            return;
        }
        
    }

    /**
     * Test of editItemInInventory method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testEditItemInInventorySuccessfull() throws Exception {
        VendingItem testItem = new VendingItem("licorice");
        testItem.setPrice(new BigDecimal(2));
        testItem.setInventory(20);
        service.editItemInInventory(testItem.getName(), testItem);
    }
    
    @Test
    public void testEditItemInInventoryDataValidation() throws Exception {
        VendingItem testItem = new VendingItem("licorice");
        testItem.setPrice(new BigDecimal(2));
        testItem.setInventory(0);
        
        try {
            service.editItemInInventory(testItem.getName(), testItem);
            fail("Expected VendingMachineDataValidationException");
        } catch (VendingMachineDataValidationException e) {
            return;
        }
        
    }

    /**
     * Test of getItemFromInventory method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetItemFromInventorySuccessful() throws Exception {
         VendingItem retrievedItem = service.getItemFromInventory("licorice");
         
         assertNotNull(retrievedItem);
    }
    
     @Test
    public void testGetItemFromInventoryNoneFound() throws Exception {
        
        try {
            VendingItem retrievedItem = service.getItemFromInventory("reese's");
            fail("Expected NoItemInInventoryException");
        } catch (NoItemInInventoryException e) {
            return;
        }
        
    }

    /**
     * Test of purchaseItemInInventory method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testPurchaseItemInInventorySuccesfull() throws Exception {
        VendingItem testItem = new VendingItem("licorice");
        testItem.setPrice(new BigDecimal(1));
        testItem.setInventory(20);
        BigDecimal money = new BigDecimal(1);
        service.purchaseItemInInventory(testItem, money);
        
    }
    
    @Test
    public void testPurchaseItemInInventoryNotEnoughCash() throws Exception {
        VendingItem testItem = new VendingItem("licorice");
        testItem.setPrice(new BigDecimal(1));
        testItem.setInventory(20);
        BigDecimal money = new BigDecimal(".50");
        
        try {
            service.purchaseItemInInventory(testItem, money);
            fail("Expected InsufficientFundsException");
        } catch (InsufficientFundsException e) {
            return;
        }
        
        
    }

    /**
     * Test of getAllItemsInInventory method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetAllItemsInInventory() throws Exception {
        assertEquals(1, service.getAllItemsInInventory().size());
    }

    /**
     * Test of getItemsInStock method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetItemsInStock() throws Exception {
        assertEquals(0, service.getItemsInStock().size());
    }
    
    @Test
    public void testCheckItemInStock() throws Exception {
        try {
            service.checkIfInStock("licorice");
            fail("Expected VendingMachineOutOfStockException to be thrown");
        } catch (VendingMachineOutOfStockException e) {
            return;
        }
    }
    
}
