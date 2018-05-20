/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

/**
 *
 * @author Jesse
 */
public class CountXX {
    
    // Count the number of "xx" in the given String. We'll say 
    // that overlapping is allowed, so "xxx" contains 2 "xx".  
    //
    // countXX("abcxx") -> 1
    // countXX("xxx") -> 2
    // countXX("xxxx") -> 3
    public int countXX(String str) {
        int count = 0;
        
        String[] countTokens = str.split("");
 
        if (countTokens.length < 2) {
            return count;
        }
        
        for (int i = 0; i < countTokens.length; i++) {
            String test = "";
            
            if (i != 0) {
                test = countTokens[i-1] + countTokens[i];
                
                if (test.equals("xx")) {
                count++;
                }
            }
            
            
            
        }
        
        return count;
    }

}
