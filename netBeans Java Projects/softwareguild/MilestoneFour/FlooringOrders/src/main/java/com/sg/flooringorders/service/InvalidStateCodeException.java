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
public class InvalidStateCodeException extends Exception {

    public InvalidStateCodeException(String message) {
        super(message);
    }

    public InvalidStateCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    
}
