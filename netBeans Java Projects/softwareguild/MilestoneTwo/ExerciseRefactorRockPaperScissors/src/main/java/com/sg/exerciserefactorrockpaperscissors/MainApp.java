/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exerciserefactorrockpaperscissors;

/**
 *
 * @author Jesse
 */
public class MainApp {
    public static void main(String[] args) {
        RockPaperScissors myRockPaperScissors = new RockPaperScissors();
        ConsoleIO mainGetUserInput  = new ConsoleIO();
        
        do {
            
            myRockPaperScissors.playRockPaperScissors();
            
            System.out.print("Do you want to play again? (y/n): ");
            myRockPaperScissors.playAgain = mainGetUserInput.getString();
            
            if (!myRockPaperScissors.playAgain.equalsIgnoreCase("y")) {
                System.out.println("Thanks for playing!");
            }
            
        } while (myRockPaperScissors.playAgain.equalsIgnoreCase("y"));
        
    }
}
