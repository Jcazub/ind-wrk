/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendingItem;
import java.util.List;

/**
 *
 * @author Jesse
 */
public interface VendingMachineDao {
    
    VendingItem addItemToInventory(String name, VendingItem item) throws VendingMachinePersistenceException;
    
    VendingItem removeItemFromInventory(String name) throws VendingMachinePersistenceException ;
    
    VendingItem editItemInInventory(String name, VendingItem item) throws VendingMachinePersistenceException;
    
    VendingItem getItemFromInventory(String name) throws VendingMachinePersistenceException;
        
    List<VendingItem> getAllItemsInInventory() throws VendingMachinePersistenceException;
    
    List<VendingItem> getItemsInStock() throws VendingMachinePersistenceException;
    
}
