/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.milestone1assignment;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class RockPaperScissors {
    
    static Scanner myScanner = new Scanner(System.in);
    static Random randomizer = new Random();
    
    public static void main(String[] args) {
        
        String playAgain;
        
        playRockPaperScissors();
        
        do {
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = myScanner.nextLine();
            
            if (playAgain.equals("y")) {
            playRockPaperScissors();
            } else {
                System.out.println("Thanks for playing!");
            }
            
        } while (playAgain.equals("y"));

    }
    
    public static void playRockPaperScissors() {
 
        int rounds;
        int computerWins = 0;
        int userWins = 0;
        int ties = 0;
        String choice;
        int choiceIndex;
        int computerChoice;
        
        System.out.println("How many rounds of Rock, Paper, Scissors do you want to play? (answer must be between 1 and 10): ");
        rounds = getNumber();
        
        if (!(rounds > 0 && rounds <= 10)) {
            System.out.println("Sorry, your input was outside the bounds");
            return;
        }
        
        for (int i = 0; i < rounds; i++){
            do {
                System.out.println("Rock, paper or scissors?");  
                choice = getLowerCaseInput();

                switch (choice) {
                    case "rock":
                        choiceIndex = 1;
                        break;
                    case "paper":
                        choiceIndex = 2;
                        break;
                    case "scissors":
                        choiceIndex = 3;
                        break;
                    default:
                        choiceIndex = 0;
                }
            } while (choiceIndex == 0);
            
            System.out.println("You chose " + choice + ".");
            
            computerChoice = computerChooses();
            
            if (choiceIndex == computerChoice) {
                ties++;
                System.out.println("This round ended in a tie!");
            } else if ((choiceIndex == 1 && computerChoice == 3) || (choiceIndex == 2 && computerChoice == 1) || (choiceIndex == 3 && computerChoice == 1)) {
                userWins++;
                System.out.println("You won this round!");
            } else {
                computerWins++;
                System.out.println("You lost this round!");
            }   
        } // For statement end
        
        System.out.println("You won " + userWins + " times, lost " + computerWins + " times and tied " + ties + " times.");
        
        if (userWins > computerWins) {
            System.out.println("Congrats! You beat the computer in Rock, Paper, Scissors!");
        } else if (computerWins > userWins) {
            System.out.println("You lost! Bummer.");
        } else {
            System.out.println("It's a GRAND OLE TIE!");
        }
    
    }
    
    public static int getNumber() {
        return Integer.parseInt(myScanner.nextLine());
    }
    
    public static String getLowerCaseInput() {
        return myScanner.nextLine().toLowerCase();
    }
    
    public static int computerChooses() {
        return randomizer.nextInt(3) + 1;
    }
    
    
}
