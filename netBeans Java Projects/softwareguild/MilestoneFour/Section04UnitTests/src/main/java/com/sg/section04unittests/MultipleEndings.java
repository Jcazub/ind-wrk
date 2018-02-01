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
public class MultipleEndings {
    // Given a String, return a new String made of 3 copies 
    // of the last 2 chars of the original String. The String 
    // length will be at least 2. 
    //
    // multipleEndings("Hello") -> "lololo"
    // multipleEndings("ab") -> "ababab"
    // multipleEndings("Hi") -> "HiHiHi"
    public String multipleEndings(String str) throws Section04UnitTestException {
        if (str.replaceAll("\\s","").length() < 2) {
            throw new Section04UnitTestException("String needs a length of 2 or more.");
        }
        
        String[] endingsArray = str.split("");
        String multipleEndingsString = "";
        
        for (int i = 0; i < 3; i++) {
            multipleEndingsString += endingsArray[endingsArray.length - 2] + endingsArray[endingsArray.length - 1];
        }
        
        return multipleEndingsString;
        
    }

}
