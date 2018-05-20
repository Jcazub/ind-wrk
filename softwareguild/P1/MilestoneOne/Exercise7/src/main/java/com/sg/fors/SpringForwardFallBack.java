/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fors;

/**
 *
 * @author Jesse
 */
public class SpringForwardFallBack {
     public static void main(String[] args) {

        System.out.println("It's Spring...!");
        // spring's for loop starts at 0 and stops before 9, incrementing each run
        // By changing the initial value to 1, and increasing the stop condition value to 11,
        // We changed spring's start/stop range to be the same as fall's
        for (int i = 1; i < 11; i++) {
            System.out.print(i + ", ");
        }

        System.out.println("\nOh no, it's fall...");
        // fall's for loop starts at 10 and stops before 1, decrementing each run
        for (int i = 10; i > 0; i--) {
            System.out.print(i + ", ");
        }
    }
}
