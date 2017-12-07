/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercisesix.whilesAndDos;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class BewareTheKraken {
     public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random randomizer = new Random();

        System.out.println("Already, get those flippers and wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLASH*");
        

        int depthDivedInFt = 0;
        String goBackUp;
        int fishType;
        // Turns out the ocean is only so deep, 36200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.
        
        // Even if the while loop just read true, the loop would break once the first if condition is met
        // Due to its break point.
        while(depthDivedInFt < 36200){
            System.out.println("So far, we've swam " + depthDivedInFt + " feet");

            if(depthDivedInFt >= 20000){
                System.out.println("Uhhh, I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            } 
            
            System.out.println("Hey, we are pretty deep. Wanna go back up? (y/n)");
            goBackUp = myScanner.nextLine();
            
            if(goBackUp.equals("y")) {
                break;
            }
            
            fishType = randomizer.nextInt(3);
            
            switch (fishType) {
                case 0:
                    System.out.println("Hey its an octopus!");
                    break;
                case 1:
                    System.out.println("OMG A WHALE!!!!");
                    break;
                case 2:
                    System.out.println("RUNNN (SWWIIMMM), ITS A SHARK!!!");
                    break;
            }
            
            

            // I can swim, really fast! 500ft at a time!
            depthDivedInFt += 1000;
        }
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
}
