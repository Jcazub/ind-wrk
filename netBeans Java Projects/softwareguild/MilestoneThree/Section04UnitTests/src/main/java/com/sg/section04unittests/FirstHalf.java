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
public class FirstHalf {
    // Given a String of even length, return the first half. 
    // So the String "WooHoo" yields "Woo". 
    //
    // firstHalf("WooHoo") -> "Woo"
    // firstHalf("HelloThere") -> "Hello"
    // firstHalf("abcdef") -> "abc"
    public String firstHalf(String str) throws Section04UnitTestException {
        
        if (str.length() % 2 != 0) {
            throw new Section04UnitTestException("Uneven string length");
        }
        
        int returnLength = str.length() / 2;
        
        return str.substring(0,returnLength);
    }

}
