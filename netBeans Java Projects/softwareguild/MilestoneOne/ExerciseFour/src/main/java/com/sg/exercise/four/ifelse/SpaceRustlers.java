/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.four.ifelse;

/**
 *
 * @author Jesse
 */
public class SpaceRustlers {
    public static void main(String[] args) {
        int spaceships = 10;
        int aliens = 25;
        int cows = 100;

        // If the number of aliens is greater than the number of spaceships, the nested code executes
        if(aliens > spaceships){
            System.out.println("Vrroom, vroom! Let's get going!");
        // If the above if statement evaluates to false, this code is run instead
        } else{
            System.out.println("There aren't enough green guys to drive these ships!");
        }

        // Executes nested code if cows is equal to spaceships
        if(cows == spaceships){
            System.out.println("Wow, way to plan ahead! JUST enough room for all these walking hamburgers!");
        // If the above if statement evaluates to false, executes nested code if cows are greater than spaceships
        // If the else statement is removed, the code will still function similarly due to how the boolean statements are written
        } else if (cows > spaceships){
            System.out.println("Dangit! I don't how we're going to fit all these cows in here!");
        // If both the if and else statements above are false, nested code is executed
        } else {
            System.out.println("Too many ships! Not enough cows.");
        }
        
        if (aliens > cows) {
            System.out.println("Hurrah, we've got the grub, Hamburger party on Alpha Centauri");  
        } else {
            System.out.println("Oh no! The herds got restless and took over! Looks like _we're_ hamburger now!!");
        }
    }
    
}
