/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

/**
 *
 * @author Jesse
 */
public class Section04UnitTestException extends Exception {
    
    public Section04UnitTestException(String message) {
        super(message);
    }
    
    public Section04UnitTestException(String message, Throwable cause) {
        super(message,cause);
    }
}
