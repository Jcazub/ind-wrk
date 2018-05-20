/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

/**
 *
 * @author Jesse
 */
public class ItemAlreadyInInventoryException extends Exception {

    public ItemAlreadyInInventoryException(String message) {
        super(message);
    }
    
    public ItemAlreadyInInventoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
