/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercisesix.whilesAndDos;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class RollerCoaster {
      public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("We're going to go on a roller coaster...");
        System.out.println("Let me know when you want to get off...!");

        String keepRiding = "y";
        int loopsLooped = 0;
        // If we changed the conditional to (keepRiding.equals("n")), the loop would
        // never be entered since the condition would be false on first pass
        while (keepRiding.equals("y")) {
            System.out.println("WHEEEEEEEEEEEEEeEeEEEEeEeeee.....!!!");
            System.out.print("Want to keep going? (y/n) :");
            keepRiding = userInput.nextLine();
            // There is no int in front of loopsLooped here because we intialized it above
            loopsLooped++;
        }

        System.out.println("Wow, that was FUN!");
        System.out.println("We looped that loop " + loopsLooped + " times!!");
    }
}
