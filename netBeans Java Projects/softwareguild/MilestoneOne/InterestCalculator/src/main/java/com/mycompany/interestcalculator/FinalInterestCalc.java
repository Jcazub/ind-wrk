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
public class FinalInterestCalc {
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
        
        System.out.print("Quarterly, monthly or daily? ");
        String answer = getInput();
              
        System.out.println("");
        
        
        
        float currentBalance = principal;
        int year = 2017;
        float quarterlyInterestMultiplier = (1 + (annualInterestRate/4) /100);
        float monthlyInterestMultiplier = (1 + (annualInterestRate/12) /100);
        float dailyInterestMultiplier = (1 + (annualInterestRate/365) /100);
        // System.out.println(monthlyInterestMultiplier);
        
        
        for (int i = 0; i < yearsInFund; i++) {
            
            if (answer.equals("quarterly")) {
                float pastBalance = currentBalance;
                System.out.println("The current year is: " + year);
                System.out.println("Current principal is: " + currentBalance);
                for (int j = 0; j < 4; j++) {
                    currentBalance *= quarterlyInterestMultiplier;
                }
                System.out.println("Total anticipated interest is: " + (currentBalance - pastBalance));
                System.out.println("Expected principal at the end of " + year + " is: " + currentBalance);
                System.out.println("");
                year++;
            } else if (answer.equals("monthly")) {
                for (int k = 0; k < 12; k++) {
                    switch (k) {
                        case 0:
                            System.out.println("The current month is January " + year);
                            break;
                        case 1:
                            System.out.println("The current month is February " + year);
                            break;
                        case 2:
                            System.out.println("The current month is March " + year);
                            break;
                        case 3:
                            System.out.println("The current month is April " + year);
                            break;
                        case 4:
                            System.out.println("The current month is May " + year);
                            break;
                        case 5:
                            System.out.println("The current month is June " + year);
                            break;
                        case 6:
                            System.out.println("The current month is July " + year);
                            break;
                        case 7:
                            System.out.println("The current month is August " + year);
                            break;
                        case 8:
                            System.out.println("The current month is September " + year);
                            break;
                        case 9:
                            System.out.println("The current month is October " + year);
                            break;
                        case 10:
                            System.out.println("The current month is November " + year);
                            break;
                        case 11:
                            System.out.println("The current month is December " + year);
                            break;
                        default:
                    }
                    float pastBalance = currentBalance;
                    System.out.println("The current principal is: " + currentBalance);
                    currentBalance *= monthlyInterestMultiplier;
                    System.out.println("Total anticipated interest is: " + (currentBalance - pastBalance));
                    System.out.println("Expected principal at the end of this month is: " + currentBalance);
                    System.out.println("");
                }
                year++;
            } else if (answer.equals("daily")) {
                for (int l = 0; l < 365; l++) {
                    System.out.println("Today is day " + (l+1) + ", " + year);
                    float pastBalance = currentBalance;
                    System.out.println("The current principal is: " + currentBalance);
                    currentBalance *= dailyInterestMultiplier;
                    System.out.println("Total anticipated interest by the end of day is: " + (currentBalance - pastBalance));
                    System.out.println("Expected principal at the end of the day is: " + currentBalance);
                    System.out.println("");
                }
                year++;
            }
            
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
