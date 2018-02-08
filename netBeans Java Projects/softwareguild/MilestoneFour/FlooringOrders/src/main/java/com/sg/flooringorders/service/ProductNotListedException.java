/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders.service;

/**
 *
 * @author Jesse
 */
public class ProductNotListedException extends Exception {

    public ProductNotListedException(String message) {
        super(message);
    }

    public ProductNotListedException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
