/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders.dao;

/**
 *
 * @author Jesse
 */
public class FlooringOrdersPersistenceException extends Exception {

    public FlooringOrdersPersistenceException(String message) {
        super(message);
    }

    public FlooringOrdersPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
