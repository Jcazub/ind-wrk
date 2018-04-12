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
import javax.inject.Inject;

/**
 *
 * @author Jesse
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {
    
    private VendingMachineDao dao;
    private Change change = new Change();
    private BigDecimal currentAmount;
    private int currentItemSelected;
    private String displayMessage;
    
    @Inject
    public VendingMachineServiceLayerImpl(VendingMachineDao dao) {
        this.dao = dao;
        this.currentAmount = new BigDecimal("0.00");
        currentItemSelected = 0;
        change = null;
        displayMessage = null;
    }

    @Override
    public void calcTotal(BigDecimal addedAmount) {
        currentAmount = currentAmount.add(addedAmount);
    }
    
    @Override
        public VendingMachineDao getDao() {
        return dao;
    }

    @Override
    public void setDao(VendingMachineDao dao) {
        this.dao = dao;
    }

    @Override
    public Change getChange() {
        return change;
    }

    @Override
    public void setChange(Change change) {
        this.change = change;
    }

    @Override
    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    @Override
    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    @Override
    public int getCurrentItemSelected() {
        return currentItemSelected;
    }

    @Override
    public void setCurrentItemSelected(int currentItemSelected) {
        this.currentItemSelected = currentItemSelected;
    }

    @Override
    public String getDisplayMessage() {
        return displayMessage;
    }

    @Override
    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }  

    @Override
    public void makePurchase() {
        if (currentItemSelected != 0) {
            VendingItem selectedItem = dao.getItem(currentItemSelected);
            BigDecimal cost = selectedItem.getCost();
            
            if (selectedItem.getQuantity() <= 0) {
                displayMessage = "SOLD OUT!";
            } else if (currentAmount.compareTo(cost) < 0) {
                BigDecimal shortBy = cost.subtract(currentAmount);
                displayMessage = "Please insert: $" + shortBy;
            } else {
                change = new Change();
                change.getChange(cost, currentAmount);
                currentAmount = new BigDecimal("0");
                selectedItem.setQuantity(selectedItem.getQuantity() - 1);
                displayMessage = "Thank You!";
            }
            
        }
    }

    @Override
    public void changeReturn() {
        change = new Change();
        change.getChange(new BigDecimal("0"), currentAmount);
        currentAmount = new BigDecimal("0");
        currentItemSelected = 0;
        displayMessage = "";
    }

    @Override
    public VendingItem getItem(int itemNumber) {
        return dao.getItem(itemNumber);
    }

    @Override
    public List<VendingItem> getAllItems() {
        return dao.getAllItems();
    }
    
}
