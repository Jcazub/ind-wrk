/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.luckysevens;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jesseazubuike
 */
public class LuckySevens {
    
    static Scanner myScanner = new Scanner(System.in);
    static Random randomizer = new Random();
    
    public static void main(String[] args) {
        
        System.out.print("How much do you have to bet partner?: ");
        float dollars = getNumber();
        float maxDollars = dollars;
        int roll = 0;
        int bestRoll = 0;
        
        while (dollars > 0) {
            int diceRoll1 = rollDice();
            int diceRoll2 = rollDice();
            roll++;
            
            if (diceRoll1 + diceRoll2 == 7) {
                dollars += 4;
            } else {
                dollars -= 1;
            }
            
            if (dollars > maxDollars) {
                maxDollars = dollars;
                bestRoll = roll;
            }
              
        }
        
        System.out.println("You are broke after " + roll + " rolls.");
        System.out.println("You should have quit after " + bestRoll + " rolls when you had $" + maxDollars + ".");
        
    }
    
    public static String getInput () { 
        return myScanner.nextLine();
    }
    
    public static float getNumber() {
        return Float.parseFloat(getInput());
    }
    
    public static int rollDice() {
        return randomizer.nextInt(6) + 1;
    }
}
