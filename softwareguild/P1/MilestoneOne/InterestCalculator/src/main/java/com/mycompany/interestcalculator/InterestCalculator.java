/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interestcalculator;

import java.util.Scanner;

/**
 *
 * @author jesseazubuike
 */
public class InterestCalculator {
    static Scanner myScanner = new Scanner(System.in);
    
    public static void main(String[] args) {
//        System.out.print("Input a number: ");
//        int x = getNumber();
//        System.out.println("Your number is: " + x);

        System.out.print("Input an annual interest rate: ");
        float annualInterestRate = getNumber();
        
        System.out.print("Input a starting principal: ");
        float principal = getNumber();
        
        System.out.print("Input total years in fund: ");
        float yearsInFund = getNumber();
        System.out.println("");
        
        float currentBalance = principal;
        int year = 2017;
        float interestMultiplier = (1 + (annualInterestRate/4) /100);
        
        
        for (int i = 0; i < yearsInFund; i++) {
            float pastBalance = currentBalance;
            System.out.println("The current year is: " + year);
            System.out.println("Current principal is: " + currentBalance);
            for (int j = 0; j < 4; j++) {
                currentBalance *= interestMultiplier;
            }
            System.out.println("Total anticipated interest is: " + (currentBalance - pastBalance));
            System.out.println("Expected principal at the end of " + year + " is: " + currentBalance);
            System.out.println("");
            year++;
        }
        
        System.out.println(currentBalance);
        
    }
    
    public static String getInput () { 
        return myScanner.nextLine();
    }
    
    public static float getNumber() {
        return Float.parseFloat(getInput());
    }
}


