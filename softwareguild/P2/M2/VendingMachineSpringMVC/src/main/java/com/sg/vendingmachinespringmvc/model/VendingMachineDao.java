/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.util.List;

/**
 *
 * @author Jesse
 */
public interface VendingMachineDao {
    
    public VendingItem getItem(Integer itemNumber);
    
    public List<VendingItem> getAllItems();
    
}
