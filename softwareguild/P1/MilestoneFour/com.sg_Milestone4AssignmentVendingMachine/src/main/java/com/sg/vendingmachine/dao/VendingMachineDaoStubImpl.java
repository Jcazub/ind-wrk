/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendingItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Jesse
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {
    
    VendingItem item1;
    List<VendingItem> itemList = new ArrayList<>();
    
    public VendingMachineDaoStubImpl() {
    
        item1 = new VendingItem("licorice");
        item1.setPrice(new BigDecimal(1));
        item1.setInventory(0);
 
        itemList.add(item1);
    }

    @Override
    public VendingItem addItemToInventory(String name, VendingItem item) throws VendingMachinePersistenceException {
        if (name.equals(item1.getName())) {
            return item1;
        } else {
            return null;
        }
  
    }

    @Override
    public VendingItem removeItemFromInventory(String name) throws VendingMachinePersistenceException {
        if (name.equals(item1.getName())) {
            return item1;
        } else {
            return null;
        }
    }

    @Override
    public VendingItem editItemInInventory(String name, VendingItem item) throws VendingMachinePersistenceException {
        if (name.equals(item1.getName())) {
            return item1;
        } else {
            return null;
        }
    }

    @Override
    public VendingItem getItemFromInventory(String name) throws VendingMachinePersistenceException {
        if (name.equals(item1.getName())) {
            return item1;
        } else {
            return null;
        }
    }

    @Override
    public List<VendingItem> getAllItemsInInventory() throws VendingMachinePersistenceException {
        return itemList;
    }

    @Override
    public List<VendingItem> getItemsInStock() throws VendingMachinePersistenceException {
        return Collections.emptyList();
    }
    
}
