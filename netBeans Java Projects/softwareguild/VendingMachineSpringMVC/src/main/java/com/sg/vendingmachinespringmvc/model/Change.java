/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.math.BigDecimal;

/**
 *
 * @author Jesse
 */
public class Change {
    
    private int quarters, dimes, knickels, pennies;
    
    // Returns amounts of quarters, dimes, knickels, pennies in change
    public void getChange(BigDecimal price, BigDecimal money) {
        quarters = 0;
        dimes = 0;
        knickels = 0;
        pennies = 0;
        
        BigDecimal change = money.subtract(price).multiply(new BigDecimal("100"));
        
        while (change.compareTo(new BigDecimal("0.00")) > 0) {
             if (change.compareTo(new BigDecimal("25.00")) >= 0) {
                  quarters++;
                  change = change.subtract(new BigDecimal("25.00"));
              } else if (change.compareTo(new BigDecimal("10.00")) >= 0) {
                  dimes++;
                  change = change.subtract(new BigDecimal("10.00"));
              } else if (change.compareTo(new BigDecimal("5.00")) >= 0) {
                  knickels++;
                  change = change.subtract(new BigDecimal("5.00"));
              } else if (change.compareTo(new BigDecimal("1.00")) >= 0) {
                  pennies++;
                  change = change.subtract(new BigDecimal("1.00"));
              } 
        }

    } 

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getKnickels() {
        return knickels;
    }

    public int getPennies() {
        return pennies;
    }
}
