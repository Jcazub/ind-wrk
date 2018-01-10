/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendingItem;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Jesse
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {
    
    Map<String, VendingItem> vendingMachineInventory = new HashMap<>();
    private static final String MACHINEINVENTORYFILE = "VendingMachineInventory.txt";
    private static final String DELIMITER = "::";
    
    @Override
    public VendingItem addItemToInventory(String name, VendingItem item) throws VendingMachinePersistenceException {
        VendingItem addedItem = vendingMachineInventory.put(name, item);
        writeToMachineInventory();
        return addedItem;
    }

    @Override
    public VendingItem removeItemFromInventory(String name) throws VendingMachinePersistenceException {
        VendingItem removedItem = vendingMachineInventory.remove(name);
        writeToMachineInventory();
        return removedItem;
    }

    @Override
    public VendingItem editItemInInventory(String name, VendingItem item) throws VendingMachinePersistenceException {
        VendingItem editedItem = vendingMachineInventory.put(name, item);
        writeToMachineInventory();
        return editedItem;
    }

    @Override
    public VendingItem getItemFromInventory(String name) throws VendingMachinePersistenceException {
        loadMachineInventory();
        VendingItem retrievedItem = vendingMachineInventory.get(name);
        return retrievedItem;
    }
    
    @Override
    public List<VendingItem> getAllItemsInInventory() throws VendingMachinePersistenceException {
        loadMachineInventory();
        List<VendingItem> allItemsInInventory = new ArrayList<>(vendingMachineInventory.values());
        return allItemsInInventory;
    }
    
    @Override
    public List<VendingItem> getItemsInStock() throws VendingMachinePersistenceException {
        loadMachineInventory();
        List<VendingItem> allItemsInInventory = this.getAllItemsInInventory();
        
        return allItemsInInventory.stream()
                .filter(i -> i.getInventory() > 0)
                .collect(Collectors.toList());
    }
    
    public void loadMachineInventory() throws VendingMachinePersistenceException {
        Scanner scanner;
        String currentLine;
        String[] currentTokens;
        
        
        try {
            scanner = new Scanner(new BufferedReader (new FileReader(MACHINEINVENTORYFILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException("Could not load Machine Inventory", e);
        }

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            VendingItem readItem = new VendingItem(currentTokens[0]);

            readItem.setPrice(new BigDecimal(currentTokens[1]));
            readItem.setInventory(Integer.parseInt(currentTokens[2]));
            
            vendingMachineInventory.put(readItem.getName(), readItem);
        }
        
        scanner.close();
        
    }
    
    public void writeToMachineInventory() throws VendingMachinePersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter( new FileWriter(MACHINEINVENTORYFILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Cound not record Machine Inventory", e);
        }
        
        List<VendingItem> allItems = getAllItemsInInventory();
        
        for (VendingItem currentItem : allItems) {
            out.println(currentItem.getName() + DELIMITER
                + currentItem.getPrice() + DELIMITER
                + currentItem.getInventory() + DELIMITER);
            out.flush();
        }
        out.close();    
    }
    
}
