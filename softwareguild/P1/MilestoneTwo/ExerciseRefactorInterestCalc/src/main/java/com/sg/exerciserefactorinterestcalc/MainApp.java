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
        UserIO io = new UserIOConsoleImpl();
        InterestCalc myInterestCalc = new InterestCalc();
        
        myInterestCalc.setAnnualInterestRate(io.readString("Input an annual interest rate: "));
          
        myInterestCalc.setPrincipal(io.readString("Input a starting principal: "));
        
        myInterestCalc.setYearsInFund(io.readInt("Input total years in fund: "));
        
        myInterestCalc.setReportRange(io.readString("Quarterly, monthly or daily? "));
              
        System.out.println("");
        
        myInterestCalc.calcInterest();
    }
}
