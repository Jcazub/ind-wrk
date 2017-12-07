/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.six.whilesAndDos;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class DoOrDoNot {
     public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Should I do it? (y/n) ");
        boolean doIt;

        if (input.next().equals("y")) {
            doIt = true; // DO IT!
        } else {
            doIt = false; // DONT YOU DARE!
        }

        boolean iDidIt = false;

//        do {
//            iDidIt = true;
//            break;
//        } while (doIt);
        
        while (doIt) {
            iDidIt = true;
            break;
        }

        if (doIt && iDidIt) {
            System.out.println("I did it!");
        } else if (!doIt && iDidIt) {
            System.out.println("I know you said not to ... but I totally did anyways.");
        } else {
            System.out.println("Don't look at me, I didn't do anything!");
        }
        
        // If told to do it, it prints out "I did it!"
        // If told not to, it prints out "I know you said not to... But I totally did anyways"
        
        // If changed to a regular while loop:
        // If told to do it, it prints our "I did it!"
        // If told not to, it prints out "Don't look at me, I didn't do anything!"
    }
}
