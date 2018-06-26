/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jesse
 */
public class VendingMachineDaoInMemImpl implements VendingMachineDao {

    HashMap<Integer, VendingItem> vendingMachine = new HashMap<>();
    
    public VendingMachineDaoInMemImpl() {
//        vendingMachine = new HashMap<>();
        vendingMachine.put(1, new VendingItem(1,9,"Snickers",new BigDecimal("1.85")));
        vendingMachine.put(2, new VendingItem(2,2,"M & Ms",new BigDecimal("1.50")));
        vendingMachine.put(3, new VendingItem(3,5,"Pringles",new BigDecimal("2.10")));
        vendingMachine.put(4, new VendingItem(4,4,"Reese's",new BigDecimal("1.85")));
        vendingMachine.put(5, new VendingItem(5,9,"Pretzels",new BigDecimal("1.25")));
        vendingMachine.put(6, new VendingItem(6,3,"Twinkies",new BigDecimal("1.95")));
        vendingMachine.put(7, new VendingItem(7,11,"Doritos",new BigDecimal("1.75")));
        vendingMachine.put(8, new VendingItem(8,0,"Almond Joy",new BigDecimal("1.85")));
        vendingMachine.put(9, new VendingItem(9,6,"Trident",new BigDecimal("1.95")));
        
    }
    
    @Override
    public VendingItem getItem(Integer itemNumber) {
        return vendingMachine.get(itemNumber);
    }

    @Override
    public List<VendingItem> getAllItems() {
        return new ArrayList<>(vendingMachine.values());
    }
    
}
