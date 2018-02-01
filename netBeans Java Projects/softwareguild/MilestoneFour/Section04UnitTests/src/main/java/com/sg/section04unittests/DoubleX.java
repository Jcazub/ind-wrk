/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesse
 */
public class DoubleX {
    
    // Given a String, return true if the first instance 
    // of "x" in the String is immediately followed by 
    // another "x". 
    //
    // doubleX("axxbb") -> true
    // doubleX("axaxxax") -> false
    // doubleX("xxxxx") -> true
    public boolean doubleX(String str) {
        String[] stringSplit = str.split("");
        
        if (stringSplit.length < 2) {
            return false;
        }
        
        for (int i = 0; i < stringSplit.length; i++) {
            if (stringSplit[i].equals("x")) {
                if (stringSplit[i] == stringSplit[stringSplit.length -1]) {
                    return false;
                } else if (stringSplit[i+1].equals("x")) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        
        return false;
    }
    
}
