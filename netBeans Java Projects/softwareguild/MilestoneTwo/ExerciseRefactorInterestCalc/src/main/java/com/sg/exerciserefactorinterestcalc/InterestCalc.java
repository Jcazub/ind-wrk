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
public class InterestCalc {
    private float annualInterestRate, principal, yearsInFund, currentBalance, quarterlyInterestMultiplier, monthlyInterestMultiplier, dailyInterestMultiplier, finalBalance, pastBalance;
    private String reportRange;
    private int year;

    public void setAnnualInterestRate(float annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setPrincipal(float principal) {
        this.principal = principal;
    }

    public void setYearsInFund(float yearsInFund) {
        this.yearsInFund = yearsInFund;
    }

    public void setReportRange(String reportRange) {
        this.reportRange = reportRange.toLowerCase();
    }
    
    private void setStartingValues() {
        this.currentBalance = this.principal;
        this.year = 2017;
        this.quarterlyInterestMultiplier = (1 + (annualInterestRate/4) /100);
        this.monthlyInterestMultiplier = (1 + (annualInterestRate/12) /100);
        this.dailyInterestMultiplier = (1 + (annualInterestRate/365) /100);
    }

    public float getAnnualInterestRate() {
        return annualInterestRate;
    }

    public float getPrincipal() {
        return principal;
    }

    public float getYearsInFund() {
        return yearsInFund;
    }

    public float getQuarterlyInterestMultiplier() {
        return quarterlyInterestMultiplier;
    }

    public float getMonthlyInterestMultiplier() {
        return monthlyInterestMultiplier;
    }

    public float getDailyInterestMultiplier() {
        return dailyInterestMultiplier;
    }

    public String getReportRange() {
        return reportRange;
    }

    public int getYear() {
        return year;
    }
    
    public void calcInterest() {
        
        this.setStartingValues();
        
        for (int i = 0; i < yearsInFund; i++) {
            
            if (reportRange.equals("quarterly")) {
                pastBalance = currentBalance;
                System.out.println("The current year is: " + year);
                System.out.println("Current principal is: " + currentBalance);
                for (int j = 0; j < 4; j++) {
                    currentBalance *= quarterlyInterestMultiplier;
                }
                System.out.println("Total anticipated interest is: " + (currentBalance - pastBalance));
                System.out.println("Expected principal at the end of " + year + " is: " + currentBalance);
                System.out.println("");
                year++;
            } else if (reportRange.equals("monthly")) {
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
            } else if (reportRange.equals("daily")) {
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
        
        finalBalance = currentBalance;
    }
    
    
}
