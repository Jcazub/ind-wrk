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
public class StringSplosion {
    // Given a non-empty String like "Code" return a String like 
    // “CCoCodCode".  (first char, first two, first 3, etc)
    //
    // stringSplosion("Code") -> "CCoCodCode"
    // stringSplosion("abc") -> "aababc"
    // stringSplosion("ab") -> "aab"
    public String stringSplosion(String str) throws Section04UnitTestException {
        if (str.replaceAll("\\s", "").length() == 0) {
            throw new Section04UnitTestException("Insert a non-empty string");
        }
        
        String[] strArray = str.split("");
        String newString = "";
        
        for (int i = 0; i < strArray.length; i++) {
            newString += str.substring(0,i+1);
        }
        
        return newString;
    }

}
