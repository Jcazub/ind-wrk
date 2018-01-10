/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.VendingItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Jesse
 */
public interface VendingMachineServiceLayer {
    
    VendingItem addItemToInventory(String name, VendingItem item) throws ItemAlreadyInInventoryException, VendingMachineDataValidationException, VendingMachinePersistenceException;
    
    VendingItem removeItemFromInventory(String name) throws NoItemInInventoryException, VendingMachinePersistenceException;
    
    VendingItem editItemInInventory(String name, VendingItem item) throws VendingMachineDataValidationException, VendingMachinePersistenceException;
    
    VendingItem getItemFromInventory(String name) throws NoItemInInventoryException, VendingMachinePersistenceException;
    
    void checkIfInStock(String name) throws VendingMachineOutOfStockException, VendingMachinePersistenceException;
    
    String purchaseItemInInventory(VendingItem item, BigDecimal money) throws InsufficientFundsException, VendingMachinePersistenceException;
    
    List<VendingItem> getAllItemsInInventory()throws VendingMachinePersistenceException;
    
    List<VendingItem> getItemsInStock() throws VendingMachinePersistenceException;
    
}
