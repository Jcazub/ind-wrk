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
public class GuessMeFinally {
    public static void main(String[] args) {
        Random randomizer = new Random();
        Scanner myScanner = new Scanner(System.in);
        int rightNumber = randomizer.nextInt(100 + 1 + 100) - 100;
        int guessedNumber;
        int guessCount = 0;
        String guessedNumberInput;
        //System.out.println(rightNumber);
        System.out.print("What is the number I'm thinking of?: ");       
        guessedNumberInput = myScanner.nextLine();
        guessedNumber = Integer.parseInt(guessedNumberInput);
        
        
        do {
            if (guessedNumber < rightNumber){
                guessCount++;
                System.out.println("Ha, nice try - too low! Try again!");
                System.out.print("Your guess: ");
                guessedNumberInput = myScanner.nextLine();
                guessedNumber = Integer.parseInt(guessedNumberInput);
            } else if (guessedNumber > rightNumber) {
                guessCount++;
                System.out.println("Too bad, way too high. Try again!");
                System.out.print("Your guess: ");
                guessedNumberInput = myScanner.nextLine();
                guessedNumber = Integer.parseInt(guessedNumberInput);
            }
            
            
        } while (guessedNumber != rightNumber);
        
        //System.out.println(guessCount);
        
        if (guessCount > 0) {
            System.out.println("Finally! It's about time you got it right! It only took you " + guessCount + " guesses!");
        } else {
            System.out.println("Wow, nice guess! That was it!");
        }
        
        
    }
}
