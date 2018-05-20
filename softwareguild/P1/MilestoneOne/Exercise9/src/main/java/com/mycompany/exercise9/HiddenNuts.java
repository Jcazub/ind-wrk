/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercise9;

import java.util.Random;

/**
 *
 * @author jesseazubuike
 */
public class HiddenNuts {
    public static void main(String[] args) {

        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
        System.out.println("The nut has been hidden ...");

		// Nut finding code should go here! 
        for (int i = 0; i < hidingSpots.length; i++) {
            //System.out.println(hidingSpots[i].equals("Nut"));
            if (hidingSpots[i] != null && hidingSpots[i].equals("Nut")) {
                System.out.println("Aha! I've found it! It was in hiding spot " + i);
                break;
            } else {
                System.out.println("Hmmm not here...");
            }
        }
    }
}
