/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.four.ifelse;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class GuessMe {
    public static void main(String[] args) {
        int rightNumber = 10;
        int guessedNumber;
        System.out.print("What is the number I'm thinking of?: ");
        Scanner myScanner = new Scanner(System.in);
        String guessedNumberInput = myScanner.nextLine();
        guessedNumber = Integer.parseInt(guessedNumberInput);
        if (guessedNumber == rightNumber) {
            System.out.println("Wow, nice guess! That was it!");
        } else if (guessedNumber < rightNumber) {
            System.out.println("Ha, nice try - too low! I chose " + rightNumber);
        } else {
            System.out.println("Too bad, way too high. I chose " + rightNumber);
        }
        
    }
}
