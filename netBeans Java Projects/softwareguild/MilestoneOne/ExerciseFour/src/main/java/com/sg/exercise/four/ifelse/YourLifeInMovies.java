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
public class YourLifeInMovies {
    public static void main(String[] args) {
        System.out.print("What is your age?: ");
        Scanner myScanner = new Scanner(System.in);
        String ageInput = myScanner.nextLine();
        int age = Integer.parseInt(ageInput);
        
        if (age < 2005) {
            System.out.println("Did you know that Pixar's 'Up' came out half a decade ago?");
        } if (age < 1995) {
            System.out.println("And that the first Harry Potter movie came out 15 years ago?");
        } if (age < 1985) {
            System.out.println("And that Space Jam came out not in the last decade, but the year BEFORE that?");
        } if (age < 1975) {
            System.out.println("And that the original Jurassic Park release is closer to the lunar landing, than today?");
        } if (age < 1965) {
            System.out.println("Aaaaannnddd that MASH has been outy for almost half a century!?!??!?");
        }
    }
}
