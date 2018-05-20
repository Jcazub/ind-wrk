/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

/**
 *
 * @author Jesse
 */
public class IncorrectPasscodeException extends Exception {
    
    public IncorrectPasscodeException(String message) {
        super(message);
    }
    
    public IncorrectPasscodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
