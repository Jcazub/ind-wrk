/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exerciserefactorrockpaperscissors;

import java.util.Random;

/**
 *
 * @author Jesse
 */
public class RockPaperScissors {
    private static ConsoleIO getUserInput = new ConsoleIO();
    private static Random randomizer = new Random();
    
    String playAgain, choice, computerChoice;
    int choiceIndex, computerChoiceIndex, rounds, computerWins, userWins, ties;
    
    public void playRockPaperScissors() {
        
        getRounds();
        
        resetTallies();
        
        for (int i = 0; i < rounds; i++){

            // ask user to pick a choice. if choice is not rock, paper, or scissors, continues to ask user
            do {
                System.out.print("Rock, paper or scissors? ");  
                choice = getUserInput.getString().toLowerCase();

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

            // randomizes computer's choice
            computerChoiceIndex = randomizer.nextInt(3) + 1;

            switch(computerChoiceIndex) {
                case 1:
                    computerChoice = "rock";
                    break;
                case 2:
                    computerChoice = "paper";
                    break;
                case 3:
                    computerChoice = "scissors";
                    break;
                default:
                    computerChoice = "";
            }

            // prints out both user's and computer's choices
            System.out.println("You chose " + choice + ".");
            System.out.println("The computer chose " + computerChoice + ".");

            // compares user and computer's choices, printing out round winner and updating tallies
            if (choiceIndex == computerChoiceIndex) {
                ties++;
                System.out.println("This round ended in a tie!");
            } else if ((choiceIndex == 1 && computerChoiceIndex == 3) || (choiceIndex == 2 && computerChoiceIndex == 1) || (choiceIndex == 3 && computerChoiceIndex == 2)) {
                userWins++;
                System.out.println("You won this round!");
            } else {
                computerWins++;
                System.out.println("You lost this round!");
            } 
            System.out.println("");
        } // For statement end

        // after all rounds are played, prints out tallies
        if (rounds != 0) {
            results();
        }
        
    }
    
    private int getRounds() {
        System.out.print("How many rounds of Rock, Paper, Scissors do you want to play? (answer must be between 1 and 10): ");
        int userInputRounds = getUserInput.getNumber();
        System.out.println("");

        // if input out of bounds, exits program
        if (!(userInputRounds > 0 && userInputRounds <= 10)) {
            System.out.println("Sorry, your input was outside the bounds");
            rounds = 0;
        } else {
            rounds = userInputRounds;
        }
        return rounds;
    }
    
    private void resetTallies() {
        computerWins = 0;
        userWins = 0;
        ties = 0;
    }
    
    private void results() {
        System.out.println("You won " + userWins + " times, lost " + computerWins + " times and tied " + ties + " times.");

        // comparing tallies, prints out overall winner
        if (userWins > computerWins) {
            System.out.println("Congrats! You beat the computer in Rock, Paper, Scissors!");
        } else if (computerWins > userWins) {
            System.out.println("You lost! Bummer.");
        } else {
            System.out.println("It's a GRAND OLE TIE!");
        }
    }
    
}
