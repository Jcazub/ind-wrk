/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.six.whilesAndDos;

import java.util.Random;

/**
 *
 * @author Jesse
 */
public class MaybeItLovesMe {
    public static void main(String[] srgs){
        Random randomizer = new Random();
        int pluck = randomizer.nextInt(89 + 1 - 13) + 13;
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
        
        if (lovesMe) {
            System.out.println("Oh, wow! It really LOVES ME!");
        } else {
            System.out.println("Aww, bummer.");
        }
        
        
    }
}
