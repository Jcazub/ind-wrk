/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

/**
 *
 * @author Jesse
 */
public class VendingMachineInputErrorException extends Exception {
    
    public VendingMachineInputErrorException (String message) {
        super(message);
    }
    
    public VendingMachineInputErrorException (String message, Throwable cause) {
        super(message, cause);
    }
}
