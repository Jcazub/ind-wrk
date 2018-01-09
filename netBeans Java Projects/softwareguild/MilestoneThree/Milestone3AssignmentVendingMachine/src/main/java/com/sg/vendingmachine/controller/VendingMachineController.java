/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.IncorrectPasscodeException;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.VendingItem;
import com.sg.vendingmachine.service.InsufficientFundsException;
import com.sg.vendingmachine.service.ItemAlreadyInInventoryException;
import com.sg.vendingmachine.service.NoItemInInventoryException;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.VendingMachineInputErrorException;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Jesse
 */
public class VendingMachineController {
    VendingMachineServiceLayer service;
    VendingMachineView view;
    
    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run() {
        boolean keepGoing = true;
        boolean developerLockOut = false;
        
        try {
           while (keepGoing) {
            
                listSelection();
                String response = enterOrExit();
                
                if (response.equalsIgnoreCase("exit")){
                        keepGoing = false;
                        break;
                    }
                
                if (response.equalsIgnoreCase("developer options")) {
                    
                        if (developerLockOut) {
                            displayLockOut();
                            continue;
                        }
                        
                        try {
                            askForPasscode();
                        } catch (IncorrectPasscodeException e) {
                            developerLockOut = true;
                            view.displayError(e.getMessage());
                            continue;
                        }
                        
                        
                        boolean developerView = true;
                        
                        while (developerView) {
                            displayDeveloperOptions();
                            switch (getSelection().toLowerCase()) {
                                case "add":
                                    addItem();
                                    break;
                                case "remove":
                                    removeItem();
                                    break;
                                case "reprice":
                                    repriceItem();
                                    break;
                                case "restock":
                                    restockItem();
                                    break;
                                case "view item":
                                    viewItem();
                                    break;
                                case "view in stock":
                                    viewInStock();
                                    break;
                                case "view all":
                                    viewAll();
                                    break;
                                case "exit":
                                    developerView = false;
                                    break;
                                default:
                                    unknownCommand();
                            }
                            
                        }
                        continue;
                            
                    }
                
                BigDecimal userCash = inputMoney();
                VendingItem itemInStock = null;
                String selection = "";
                
                do {
                    selection = getSelection();
                    
                    try {
                        itemInStock = checkIfInInventory(selection);
                    } catch (NoItemInInventoryException e) {
                        displayReselect();
                        view.displayError(e.getMessage());
                    }
                } while (itemInStock == null);
                
                    try {
                       tryToPurchaseItem(itemInStock, userCash); 
                    } catch (InsufficientFundsException e) {
                        view.displayError(e.getMessage());
                        continue;
                    }

            } 
        } catch (VendingMachinePersistenceException e) {
            view.displayError(e.getMessage());
        }
        exitMessage();
    }
    
    private void listSelection()  throws VendingMachinePersistenceException {
        List<VendingItem> itemsInStock = service.getItemsInStock();
        
        view.displayAllItems(itemsInStock);  
    }
    
    private String enterOrExit() {
        return view.enterOrExit();
    }
    
    private BigDecimal inputMoney() {
        BigDecimal money = null;
        boolean inputError = false;
        
        do {       
            try {
                money = view.getMoney();
                inputError = false;
            } catch (VendingMachineInputErrorException e) {
                inputError = true;
                view.displayError(e.getMessage());
            }
        } while (inputError);
        
        
        return money;
    }
    
    private String getSelection() {
        return view.getSelection();
    }
    
    private VendingItem checkIfInInventory(String selection) throws VendingMachinePersistenceException, NoItemInInventoryException {      
         return service.getItemFromInventory(selection);
    }
    
    private void displayReselect() {
        view.displayReselect();
    }
    
    private void tryToPurchaseItem(VendingItem item, BigDecimal money) throws VendingMachinePersistenceException, InsufficientFundsException {
        
        String changeReturned = service.purchaseItemInInventory(item, money); 
        view.displayChange(item, changeReturned);
        view.pressEnterToContinue();    
    }
    
    private void askForPasscode() throws IncorrectPasscodeException {
        int tries = 5;
        int attempts = 0;
        
        while (attempts < tries) {
            int passCode = view.askForPasscode();
            if (passCode == 12345) {
                return;
            } else {
                attempts++; 
            }
        }
        
        throw new IncorrectPasscodeException("Number of attempts exceeded.");     
    }
    
    private void displayLockOut() {
        view.displayLockOut();
    }
    
    private void displayDeveloperOptions() {
        view.displayDevelopOptions();
    }
    
    private void addItem() throws VendingMachinePersistenceException{
        boolean hasErrors = false;
        
        do {       
            try {
                VendingItem addedItem = view.getNewItem();
                service.addItemToInventory(addedItem.getName(), addedItem);
                hasErrors = false;
                view.displayAddedItemBanner();
            } catch (VendingMachineDataValidationException | VendingMachineInputErrorException e) {
                hasErrors = true;
                view.displayError(e.getMessage());
            } catch (ItemAlreadyInInventoryException e) {
                hasErrors = false;
                view.displayError(e.getMessage());
            }
        } while (hasErrors);
         view.pressEnterToContinue();
    }
    
    private void removeItem() throws VendingMachinePersistenceException {
        String selection;
        VendingItem itemToRemove = null;
        boolean verification = false;
        
        do {
            selection = getSelection();
            
            try {
                itemToRemove = service.removeItemFromInventory(selection);
            } catch (NoItemInInventoryException e) {
                view.displayError(e.getMessage());
                verification = view.verify("Retry?");
            }
        } while (itemToRemove == null || verification == true);
    }
    
    private void editItem() throws VendingMachinePersistenceException {
       
            String selection = getSelection();
            try {
                VendingItem itemToEdit = service.getItemFromInventory(selection);
                boolean dataValidationError = false;
                do {
                    VendingItem editedItem = view.getEditedItem(itemToEdit);
                    try {
                        service.editItemInInventory(itemToEdit.getName(), editedItem);
                        dataValidationError = false;
                        view.displayEditedItemBanner();
                    } catch (VendingMachineDataValidationException e) {
                        dataValidationError = true;
                        view.displayError(e.getMessage());
                    }
                } while(dataValidationError);
            } catch (NoItemInInventoryException e) {
                view.displayError(e.getMessage());
            }
       
    }
    
    private void repriceItem() throws VendingMachinePersistenceException {
        
        String selection = getSelection();
        try {
            VendingItem itemToReprice = service.getItemFromInventory(selection);
                boolean dataValidationError = false;
                do {
                    itemToReprice = view.getNewPrice(itemToReprice);
                    try {
                        service.editItemInInventory(itemToReprice.getName(), itemToReprice);
                        dataValidationError = false;
                        view.displayRepriceItemBanner();
                    } catch (VendingMachineDataValidationException e) {
                        dataValidationError = true;
                        view.displayError(e.getMessage());
                    }
                } while(dataValidationError);
        } catch (NoItemInInventoryException e) {
                    view.displayError(e.getMessage());
        }
        
    }
    
    private void restockItem() throws VendingMachinePersistenceException {
        
        String selection = getSelection();
        try {
            VendingItem itemToRestock = service.getItemFromInventory(selection);
                boolean dataValidationError = false;
                do {
                    itemToRestock = view.getNewStock(itemToRestock);
                    try {
                        service.editItemInInventory(itemToRestock.getName(), itemToRestock);
                        dataValidationError = false;
                        view.displayRestockItemBanner();
                    } catch (VendingMachineDataValidationException e) {
                        dataValidationError = true;
                        view.displayError(e.getMessage());
                    }
                } while(dataValidationError);
        } catch (NoItemInInventoryException e) {
                    view.displayError(e.getMessage());
        }   
    }
    
    private void viewItem() throws VendingMachinePersistenceException {
        String selection = getSelection();
        try {
            VendingItem selectedItem = service.getItemFromInventory(selection);
            view.displayItem(selectedItem);
        } catch (NoItemInInventoryException e) {
            view.displayError(e.getMessage());
        }
    }
    
    private void viewInStock() throws VendingMachinePersistenceException{
        List<VendingItem> inStock = service.getItemsInStock();
        view.displayAllItems(inStock);
    }
    
    private void viewAll() throws VendingMachinePersistenceException{
        List<VendingItem> allItems = service.getAllItemsInInventory();
        view.displayAllItems(allItems);
        
    }
    private void unknownCommand() {
        view.unknownCommand();
    }
    
    private void exitMessage() {
        view.exitMessage();
    }
    
    
    
}
