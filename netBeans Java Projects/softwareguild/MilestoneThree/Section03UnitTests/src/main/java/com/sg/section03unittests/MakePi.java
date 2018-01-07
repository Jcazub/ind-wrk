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
public class MakePi {
    
    // Return an int array length n containing the first n digits of pi.
    //
    // makePi(3) -> {3, 1, 4}

    public int[] makePi(int n) {
        String stringPi = "314159265358979323846";
        int[] piIntN = new int[n];
        
        String[] stringPiSplit = stringPi.split("");
        
        for (int i = 0; i < piIntN.length; i++) {
            piIntN[i] = Integer.parseInt(stringPiSplit[i]);
        }
        
        return piIntN;
    }
}
