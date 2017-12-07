/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.five.random;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class HighRoller {
     public static void main(String[] args) {

        Random diceRoller = new Random();
        Scanner myScanner = new Scanner(System.in);
        
        System.out.print("Hey there, adventurer. How many sides does your dice have?: ");
        String diceInput = myScanner.nextLine();
        int dice = Integer.parseInt(diceInput);
         System.out.println("A "+dice+" sided die? Nice.");
        
        int rollResult = diceRoller.nextInt(dice) + 1;

        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);

        if (rollResult == 1) {
            System.out.println("You rolled a critical failure! Ouch.");
        } else if (rollResult == dice) {
            System.out.println("You rolled a critical! Nice Job!");
        } 
    }
}
