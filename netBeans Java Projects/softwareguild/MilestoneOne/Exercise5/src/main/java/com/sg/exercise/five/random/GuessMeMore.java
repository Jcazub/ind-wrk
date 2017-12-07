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
public class GuessMeMore {
    public static void main(String[] args) {
        Random randomizer = new Random();
        Scanner myScanner = new Scanner(System.in);
        int rightNumber = randomizer.nextInt(100 + 1 + 100) - 100;
        int guessedNumber;
        String guessedNumberInput;
        System.out.print("What is the number I'm thinking of?: ");       
        guessedNumberInput = myScanner.nextLine();
        guessedNumber = Integer.parseInt(guessedNumberInput);
        
        //System.out.println(rightNumber);
        
        if (guessedNumber < rightNumber){
            System.out.println("Ha, nice try - too low! Try again!");
            System.out.print("Your guess: ");
            guessedNumberInput = myScanner.nextLine();
            guessedNumber = Integer.parseInt(guessedNumberInput);
        } else if (guessedNumber > rightNumber) {
            System.out.println("Too bad, way too high. Try again!");
            System.out.print("Your guess: ");
            guessedNumberInput = myScanner.nextLine();
            guessedNumber = Integer.parseInt(guessedNumberInput);
        }
        
        if (guessedNumber == rightNumber) {
            System.out.println("Wow, nice guess! That was it!");
        } else {
            System.out.println("Better luck next time!");
        }
        
        
        
        
//        if (guessedNumber == rightNumber) {
//            System.out.println("Wow, nice guess! That was it!");
//        } else if (guessedNumber < rightNumber) {
//            System.out.println("Ha, nice try - too low! I chose " + rightNumber);
//        } else {
//            System.out.println("Too bad, way too high. I chose " + rightNumber);
//        }
        
    }
}
