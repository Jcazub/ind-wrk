/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.VendingItem;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author Jesse
 */
public class VendingMachineView {
    private UserIO io;
    
    public VendingMachineView(UserIO io) {
        this.io = io;
    }
    
    public void displayAllItems(List<VendingItem> inInventory) {
        inInventory.stream()
                .forEach(i -> io.print(i.getName() + ": $" + i.getPrice()));
    }
    
    public void displayItem(VendingItem itemToDisplay) {
        io.print(itemToDisplay.getName() + ": $" + itemToDisplay.getPrice());
    }
    
    public String getSelection() {
        return io.readString("Selection?: ");
    }
    
    public BigDecimal getMoney() throws VendingMachineInputErrorException {
        BigDecimal money = null;
        
        try {
          money = new BigDecimal(io.readString("Input Cash (ex. $100.00): "));  
        } catch (NumberFormatException e) {
            throw new VendingMachineInputErrorException("Expected a number", e);  
        }
        
       return money; 
    }
    
    public void displayError(String errMessage) {
        io.print("===== ERROR =====");
        io.print(errMessage);
    }
    
    public void displayReselect() {
        io.print("Not a valid choice. Pick again.");
    }
    
    public void displayChange(VendingItem item, String changeReturned) {
        io.print(item.getName() + " successfully purchased.");
        io.print(changeReturned);
    }
    
    public void pressEnterToContinue() {
        io.readString("Press Enter to continue");
    }
    
    public int askForPasscode() {
        return io.readInt("Enter Passcode: ");
    }
    
    public void displayDevelopOptions() {
        io.print("Developer Options: ");
        io.print("          1. Add item to Machine");
        io.print("          2. Remove item from Machine");
        io.print("          3. Change item price");
        io.print("          4. Restock item's inventory");
        io.print("          5. View an item's inventory");
        io.print("          6. List items in stock");
        io.print("          7. List All items in inventory"); 
        io.print("          8. Exit Developer Options");
        
    }
    
    public VendingItem getNewItem() throws VendingMachineInputErrorException {
        VendingItem item  = new VendingItem(io.readString("Enter name: "));
        
        try {
            item.setPrice(new BigDecimal(io.readString("Enter price: ")));
        } catch (NumberFormatException e) {
            throw new VendingMachineInputErrorException("Expected a number", e);  
        }

        item.setInventory(io.readInt("Enter inventory: "));
        return item;
    }
    
    public void displayAddedItemBanner() {
        io.print("===== Item added successfully =====");
    }
    
    public VendingItem getEditedItem(VendingItem itemToEdit) {
 
        Boolean keepGoing = true;
        
        do {
            io.print("     Which field would you like to edit?");
            io.print("              1. Price");
            io.print("              2. Inventory");
            int editChoice = io.readInt("Choice: ",1,2);
        
            switch (editChoice) {
            
            case 1: 
                itemToEdit.setPrice(new BigDecimal((io.readString("Enter Price: "))));
                break;
            case 2:
                itemToEdit.setInventory(io.readInt("Enter Inventory: "));
                break;
            default:
                this.unknownCommand();
            } 
            
            String another = io.readString("Edit another field? (y/n): ");
            
            if(!another.equalsIgnoreCase("y")) {
                keepGoing = false;
            }
        } while (keepGoing);
        
        
        return itemToEdit;
    }
    
    public void displayEditedItemBanner() {
        io.print("===== Item edited successfully =====");
    }
    
    public void displayRepriceItemBanner() {
        io.print("===== Item repriced successfully =====");
    }
    
    public void displayRestockItemBanner() {
        io.print("===== Item restocked successfully =====");
    }
    
    public void unknownCommand() {
        io.print("===== Unknown Command =====");
    }
    
    public void exitMessage() {
        io.print("Exiting Machine...");
    }
    
    public VendingItem getNewStock(VendingItem item) {
        
        int newStock = io.readInt("Enter new inventory for this item: ");
        item.setInventory(newStock);
        
        return item;
    }
    
    public VendingItem getNewPrice(VendingItem item) {
        
        BigDecimal newPrice = new BigDecimal(io.readString("Enter new price for this item: "));
        item.setPrice(newPrice);
        
        return item;
    }
    
    public String enterOrExit() {
        return io.readString("Press Enter to input cash. Type exit to Exit");
    }
    
    public void displayLockOut() {
        io.print("===== Locked Out Of Developer View =====");
    }
    
    public boolean verify(String message) {
        String verification;
        
        do {
        verification = io.readString(message + " (y/n): ");
        } while(!(verification.equalsIgnoreCase("y") || verification.equalsIgnoreCase("n")));
        
        return verification.equalsIgnoreCase("y");
    }
    
    
}
