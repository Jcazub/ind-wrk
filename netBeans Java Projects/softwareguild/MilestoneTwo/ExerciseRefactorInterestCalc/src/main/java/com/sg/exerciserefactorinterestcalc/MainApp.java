/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exerciserefactorinterestcalc;

/**
 *
 * @author Jesse
 */
public class MainApp {
    public static void main(String[] args) {
        ConsoleIO getUserInput = new ConsoleIO();
        InterestCalc myInterestCalc = new InterestCalc();
        
        System.out.print("Input an annual interest rate: ");
        myInterestCalc.setAnnualInterestRate(getUserInput.getNumberFloat());
        
        System.out.print("Input a starting principal: ");
        myInterestCalc.setPrincipal(getUserInput.getNumberFloat());
        
        System.out.print("Input total years in fund: ");
        myInterestCalc.setYearsInFund(getUserInput.getNumberFloat());
        
        System.out.print("Quarterly, monthly or daily? ");
        myInterestCalc.setReportRange(getUserInput.getString());
              
        System.out.println("");
        
        myInterestCalc.calcInterest();
    }
}
