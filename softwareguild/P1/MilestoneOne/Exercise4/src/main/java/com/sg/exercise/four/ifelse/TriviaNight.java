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
public class TriviaNight {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int answersRight = 0;
        
        System.out.println("It's TRIVIA NIGHT! Are you ready?!");
        System.out.println("");
        System.out.println("FIRST QUESTION!");
        System.out.println("What is the Lowest Level Programming Language?");
        System.out.println("1) Soure Code           2) Assembly Language");
        System.out.println("2) C#                   3) Machine Code");
         
        String responeOneInput = myScanner.nextLine();
        int responseOne = Integer.parseInt(responeOneInput);
        
        System.out.println("");
        System.out.println("YOUR ANSWER: " + responseOne);
        System.out.println("");
        
        System.out.println("SECOND QUESTION!");
        System.out.println("Website Security CAPTCHA Forms Are Descended From the Work of?");
        System.out.println("1) Grace Hopper         2) Alan Turing");
        System.out.println("2) Charles Babbage      3) Larry Page");
        
        String responeTwoInput = myScanner.nextLine();
        int responseTwo = Integer.parseInt(responeTwoInput);
        
        System.out.println("");
        System.out.println("YOUR ANSWER: " + responseTwo);
        System.out.println("");
        
        System.out.println("LAST QUESTION!");
        System.out.println("Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?");
        System.out.println("1) Serenity             2) The Battlestar Galactica");
        System.out.println("2) The USS Enterprise   3) The Millennium Falcon");
        
        String responeThreeInput = myScanner.nextLine();
        int responseThree = Integer.parseInt(responeThreeInput);
        
        System.out.println("");
        System.out.println("YOUR ANSWER: " + responseThree);
        System.out.println("");
        
        if (responseOne == 4) {
            answersRight++;
        } if (responseTwo == 2) {
            answersRight++;
        } if (responseThree == 3) {
            answersRight++;
        }
        
        if (answersRight == 3) {
            System.out.println("AWESOME!!! You got all of 'em right!");
        } if (answersRight == 2){
            System.out.println("Good job! You got 2 right!");
        } if (answersRight == 1) {
            System.out.println("One right isn't too bad!");
        } if (answersRight == 0) {
            System.out.println("You gotta brush up on your nerd history! You didn't get any answers right!");
        }
        
    }
}
