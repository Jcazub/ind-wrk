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
public class KnockKnock {
     public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Knock Knock! Guess who!! ");
        String nameGuess = inputReader.nextLine();

        // nameGuess == "Marty McFly" doesn't work because == is not used to compare strings
        // The string is also 
        if(nameGuess.equals("Marty McFly")){
            System.out.println("Hey! That's right! I'm back!");
            System.out.println(".... from the Future."); // Sorry, had to!
        }else{
            System.out.println("Dude, do I -look- like " + nameGuess);
        }
    }
}
