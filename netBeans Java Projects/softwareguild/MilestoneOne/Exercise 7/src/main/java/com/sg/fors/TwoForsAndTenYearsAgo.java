/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fors;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class TwoForsAndTenYearsAgo {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("What year would you like to count back from? ");
        int year = userInput.nextInt();

        // The start/stop range for this loop is from the 0 years removed from the year given to 10
        // years removed from the year given
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " years ago would be " + (year - i));
        }

        
        System.out.println("\nI can count backwards using a different way too...");

        // The start/stop range for this loop is the year given to 10 minus the year given
        for (int i = year; i >= year - 20; i--) {
            System.out.println( (year - i) + " years ago would be " + i);
        }
        
        // The first loop is clearer because the incrementation is easier to understand, as well as how the
        // incrementation interacts with the input to produce the output.
    }
}
