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
public class EveryOther {
    // Given a String, return a new String made of every other 
    // char starting with the first, so "Hello" yields "Hlo". 
    //
    // everyOther("Hello") -> "Hlo"
    // everyOther("Hi") -> "H"
    // everyOther("Heeololeo") -> "Hello"
    public String everyOther(String str) {
        String[] everyOtherArray = str.split("");
        String everyOtherString = "";
        
        for (int i = 0; i < everyOtherArray.length; i++) {
            if (i%2 == 0) {
                everyOtherString += everyOtherArray[i];
            }
        }
        
        return everyOtherString;
    }

}
