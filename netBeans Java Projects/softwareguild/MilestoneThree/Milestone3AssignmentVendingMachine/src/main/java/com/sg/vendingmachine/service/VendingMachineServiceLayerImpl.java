/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.VendingItem;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Jesse
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer{
    
    VendingMachineDao dao;
    Change change = new Change();
    
    public VendingMachineServiceLayerImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    @Override
    public VendingItem addItemToInventory(String name, VendingItem item) throws ItemAlreadyInInventoryException, VendingMachineDataValidationException, VendingMachinePersistenceException {
        if (dao.getItemFromInventory(name) != null) {
            throw new ItemAlreadyInInventoryException("Item already found in machine. Replenish inventory if low.");
        }
        
        this.validateItemData(item);
        
        return dao.addItemToInventory(name, item);
        
    }

    @Override
    public VendingItem removeItemFromInventory(String name) throws NoItemInInventoryException, VendingMachinePersistenceException {
        
        if (dao.getItemFromInventory(name) == null) {
            throw new NoItemInInventoryException("Item cannot be found in inventory");
        }
        
        return dao.removeItemFromInventory(name);
    }

    @Override
    public VendingItem editItemInInventory(String name, VendingItem item) throws VendingMachineDataValidationException, VendingMachinePersistenceException {
        
//        if (dao.getItemFromInventory(name) == null) {
//            throw new NoItemInInventoryException("Item cannot be found in inventory");
//        }
        
        this.validateItemData(item);
        
        return dao.editItemInInventory(name, item);
    }

    @Override
    public VendingItem getItemFromInventory(String name) throws NoItemInInventoryException, VendingMachinePersistenceException {
        
        VendingItem item = dao.getItemFromInventory(name);
        
        if (item == null) {
            throw new NoItemInInventoryException("Item cannot be found in inventory");
        }
        return item;
    }
    
    @Override
    public void checkIfInStock(String name) throws VendingMachineOutOfStockException, VendingMachinePersistenceException {
   
        List<VendingItem> inStock = dao.getItemsInStock().stream()
                .filter(i -> i.getName().equals(name))
                .collect(Collectors.toList());
        
        if (inStock.isEmpty()) {
            throw new VendingMachineOutOfStockException("Item is out of stock");
        }
    }
    
    @Override
    public String purchaseItemInInventory(VendingItem item, BigDecimal money) throws InsufficientFundsException, VendingMachinePersistenceException {
        
        if (item.getPrice().compareTo(money) > 0) {
            throw new InsufficientFundsException("Not enough cash to vend this option.");
        }
        
        int previousInventory = item.getInventory();
        
        item.setInventory(previousInventory - 1);
        
        dao.editItemInInventory(item.getName(), item);
        
        change.getChange(item.getPrice(), money);
        
        
        String changeString;
        if (change.getQuarters() > 0) {
          changeString = "Item Vended. Your change is " + change.getQuarters() 
                  + " quarters, " + change.getDimes() + " dimes, " 
                  + change.getKnickels() + " knickels, "
                  + change.getPennies() + " pennies.";
        } else if (change.getDimes() > 0) {
            changeString = "Item Vended. Your change is " + change.getDimes() + " dimes, " 
                  + change.getKnickels() + " knickels, "
                  + change.getPennies() + " pennies.";
        } else if (change.getKnickels() > 0) {
            changeString = "Item Vended. Your change is " 
                  + change.getKnickels() + " knickels, "
                  + change.getPennies() + " pennies.";
        } else if (change.getPennies() > 0) {
            changeString = "Item Vended. Your change is "
                  + change.getPennies() + " pennies.";
        } else {
            changeString = "Exact money inputed. No change returned.";
        }
         
        
        return changeString;
    }

    @Override
    public List<VendingItem> getAllItemsInInventory() throws VendingMachinePersistenceException {
        return dao.getAllItemsInInventory();
    }

    @Override
    public List<VendingItem> getItemsInStock() throws VendingMachinePersistenceException {
        return dao.getItemsInStock();
    }
    
    private void validateItemData(VendingItem item) throws VendingMachineDataValidationException {
        
        if (item.getName()== null
                || item.getName().trim().length() == 0
                || item.getPrice() == new BigDecimal(0)
                || item.getInventory() == 0) {
            
            throw new VendingMachineDataValidationException("ERROR: Name not given and/or price/inventory 0.");
                }
    }
    
}
