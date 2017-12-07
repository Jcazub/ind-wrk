/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fors;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class ForTimesFor {
     public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Which times table shall I recite?: ");
        String numberInput = myScanner.nextLine();
        int number = Integer.parseInt(numberInput);
        String queryInput;
        int query;
        int correctCount = 0;
        float score;
        
        for (int i = 1; i <= 15; i++) {
            System.out.print(i + " * " + number + " is: ");
            queryInput = myScanner.nextLine();
            query = Integer.parseInt(queryInput);
            if ((i*number == query)) {
                System.out.println("Correct!");
                correctCount++;
            } else {
                System.out.println("Sorry no, the answer is: " + (i*number));
            }
        }
        
        System.out.println("You got " + correctCount + " correct.");
        score = correctCount * 100.0f / 15;
        
        if (score < 50) {
            System.out.println(score + "%! You should really study your times tables more.");
        } else if (score > 90) {
            System.out.println(score + "%! You really know your times tables!");
        }
    }
}
