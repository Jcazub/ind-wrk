/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.three.scanner;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class AllTheTrivia {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        
        System.out.print("1,024 Gigabytes is equal to one what? ");
        String answerOne = myScanner.nextLine();
        System.out.print("In our solar system which is the only planet that rotates clockwise? ");
        String answerTwo = myScanner.nextLine();
        System.out.print("The largest volcano ever discovered in our solar system is located on which planet? ");
        String answerThree = myScanner.nextLine();
        System.out.print("What is the most abundant element in the earth's atmosphere? ");
        String answerFour = myScanner.nextLine();
        System.out.println("");
        
        System.out.println("Wow, 1,024 Gigabytes is a " + answerThree + "!");
        System.out.println("I didn't know that the largest ever volcano was discovered on " + answerOne + "!");
        System.out.println("That's amazing that " + answerTwo + " is the most abundant element in the atmosphere...");
        System.out.println(answerFour + " is the only planet that rotates clockwise, neat!");
    }
    
    
}
