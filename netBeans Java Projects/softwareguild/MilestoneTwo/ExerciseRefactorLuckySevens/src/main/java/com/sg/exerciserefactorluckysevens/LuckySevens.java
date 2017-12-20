/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exerciserefactorluckysevens;

import java.util.Random;

/**
 *
 * @author Jesse
 */
public class LuckySevens {
    
    private static Random randomizer = new Random();
    private static ConsoleIO getUserInput = new ConsoleIO();
    
    private float dollars, maxDollars;
    int roll, bestRoll, diceRoll1, diceRoll2;
    
    public void playLuckySevens() {
        
        System.out.print("How much do ya wanna bet partner?: ");
        
        dollars = getUserInput.getNumber();
        
        while (dollars > 0) {
            diceRoll1 = rollDice();
            diceRoll2 = rollDice();
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
    
    private int rollDice() {
        return randomizer.nextInt(6) + 1;
    }
    
}
