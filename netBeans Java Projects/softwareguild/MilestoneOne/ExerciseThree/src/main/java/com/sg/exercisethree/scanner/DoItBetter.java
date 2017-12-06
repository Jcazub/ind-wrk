/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercisethree.scanner;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class DoItBetter {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Hey there bud, how many miles can ya run? ");
        int miles = myScanner.nextInt();
        System.out.print("HA! I can run " + (miles*2 + 1) + ". How about hot dogs, hwo many of em can you hog down? ");
        int hotDogs = myScanner.nextInt();
        System.out.println("Only " + hotDogs + "? I can chow down " + (hotDogs*2 + 1) + " in one sitting!");
        System.out.print("At least you are more culturally enriched than I am right? How many languages ya know? ");
        int languages = myScanner.nextInt();
        System.out.println("WHAT! ONLY " + languages + "? I know like " + (languages*2 +1) + " languages! I guess I really am better than you in every way huh?");
        
    }
}
