/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercisesix.whilesAndDos;

import java.util.Random;

/**
 *
 * @author Jesse
 */
public class LazyTeenager {
    public static void main(String[] args) {
        Random randomizer = new Random();
        int askCount = 0;
        int cleanChance;
        int chanceModifier = 5;
        
        do {
            askCount++;
            System.out.println("Clean your room!!" + "(x" + askCount + ")");
            if (askCount == 15) {
                System.out.println("That's IT, I'm doing it!!! You're grounded and I'm taking your XBOX!");
                break;
            }
            
            cleanChance = randomizer.nextInt(100);
            System.out.println(cleanChance);
            
            if (cleanChance < chanceModifier) {
                System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
                break;
            }
            
            chanceModifier += 5;
            System.out.println(chanceModifier);
            
        } while (askCount <= 15);
    }
}
    
