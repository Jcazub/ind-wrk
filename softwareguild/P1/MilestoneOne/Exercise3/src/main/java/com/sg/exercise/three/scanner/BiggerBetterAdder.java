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
public class BiggerBetterAdder {
     public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Give me 3 numbers to add: ");
        int num1, num2, num3, numsAdded;
        num1 = myScanner.nextInt();
        System.out.println("The first number is " + num1);
        num2 = myScanner.nextInt();
        System.out.println("The second number is " + num2);
        num3 = myScanner.nextInt();
        System.out.println("The third number is " + num3);
        
        numsAdded = num1 + num2 + num3;
        
        System.out.println("The sum of " + num1 + ", " + num2 + ", " + num3 + " is equal to " + numsAdded + ". That is " + numsAdded + ".");
    }
}
