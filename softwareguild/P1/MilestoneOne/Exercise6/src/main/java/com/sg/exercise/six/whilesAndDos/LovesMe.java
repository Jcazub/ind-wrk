/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.six.whilesAndDos;

/**
 *
 * @author Jesse
 */
public class LovesMe {
    public static void main(String[] srgs){
        int pluck = 34;
        boolean lovesMe = false;
        
        System.out.println("Well here goes nothing...");
        
        while (pluck >= 0) {
            
            lovesMe = !lovesMe;
            if (lovesMe) {
                System.out.println("It LOVES me!");
            } else if (!lovesMe) {
                System.out.println("It loves me NOT!");
            }
            
            pluck--;
            
        }
        
        System.out.println("I knew it! It LOVES ME!");
        
    }
}
