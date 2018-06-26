/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.VendingItem;
import com.sg.vendingmachinespringmvc.model.VendingMachineDao;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Jesse
 */
public interface VendingMachineServiceLayer {
    
    public VendingMachineDao getDao();
    
    public void setDao(VendingMachineDao dao);
    
    public Change getChange();
    
    public void setChange(Change change);
    
    public BigDecimal getCurrentAmount();
    
    public void setCurrentAmount(BigDecimal currentAmount);
    
    public int getCurrentItemSelected();
    
    public void setCurrentItemSelected(int currentItemSelected);
    
    public String getDisplayMessage();
    
    public void setDisplayMessage(String displayMessage);
    
    public void calcTotal(BigDecimal addedAmount);
    
    public void makePurchase();
    
    public void changeReturn();
    
    public VendingItem getItem(int itemNumber);
    
    public List<VendingItem> getAllItems();
    
    public boolean checkIfChangeIsEmpty();
    
}
