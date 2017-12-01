/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.two.variables;

/**
 *
 * @author Jesse
 */
public class TheOderOfThings {
     public static void main(String[] args) {

        double number;
        String opinion, size, age, shape, color, origin, material, purpose;
        String noun;

        number = 5.0;
        opinion = " AWESOME ";
        size = "teensy-weensy ";
        age = "new ";
        shape = "oblong ";
        color = "BRIGHT yellow ";
        origin = "AlphaCentaurian ";
        material = "platinum ";
        purpose = "good ";

        noun = "dragons";

        // Using the + with strings, doesn't add it concatenates! (sticks them together)
        System.out.println(number + opinion + size + age + shape + color
                + origin + material + purpose + noun);
        
         System.out.println(number + age + opinion + shape + material + purpose + size + color + origin + noun);
         
         //This first string sounds better
    }
}
