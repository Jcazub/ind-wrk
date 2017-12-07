/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.six.whilesAndDos;

/**
 *
 * @author Jesse
 */
public class WaitAWhile {
     public static void main(String[] args) {

        // If timeNow is also changed to 11, the loop will never evaluate since the condition
        // is false.
        int timeNow = 5;
        // If bedTime is changed to 11, the loop will iterate one more time
        // Since the value of one of the variables in the condition changed
        int bedTime = 11;

        while (timeNow < bedTime) {
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a liiiiittle longer....");
            // If timeNow++ is commented out, the loop will continue to run indifinitely since the condition
            // will always be true
            timeNow++; // Time passes
        }

        System.out.println("Oh. It's " + timeNow + " o'clock.");
        System.out.println("Guess I should go to bed ...");
    }
}
