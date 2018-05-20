/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exerciserefactorinterestcalc;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Jesse
 */
public class InterestCalc {

    private BigDecimal annualInterestRate, principal, currentBalance, quarterlyInterestMultiplier, monthlyInterestMultiplier, dailyInterestMultiplier, finalBalance, pastBalance;
    private String reportRange;
    private int year, yearsInFund;
    UserIO io = new UserIOConsoleImpl();

    public void setAnnualInterestRate(String annualInterestRate) {
        this.annualInterestRate = new BigDecimal(annualInterestRate);
    }

    public void setPrincipal(String principal) {
        this.principal = new BigDecimal(principal);
    }

    public void setYearsInFund(int yearsInFund) {
        this.yearsInFund = yearsInFund;
    }

    public void setReportRange(String reportRange) {
        this.reportRange = reportRange.toLowerCase();
    }

    private void setStartingValues() {
        this.currentBalance = this.principal;
        this.year = 2017;
        //this.quarterlyInterestMultiplier = (1 + (annualInterestRate/4) /100);
        this.quarterlyInterestMultiplier = annualInterestRate.divide(new BigDecimal("4"), 6, RoundingMode.HALF_UP).divide(new BigDecimal("100"), 6, RoundingMode.HALF_UP).add(new BigDecimal("1"));
        //this.monthlyInterestMultiplier = (1 + (annualInterestRate/12) /100);
        this.monthlyInterestMultiplier = annualInterestRate.divide(new BigDecimal("12"), 6, RoundingMode.HALF_UP).divide(new BigDecimal("100"), 6, RoundingMode.HALF_UP).add(new BigDecimal("1"));
        //this.dailyInterestMultiplier = (1 + (annualInterestRate/365) /100);
        this.dailyInterestMultiplier = annualInterestRate.divide(new BigDecimal("365"), 6, RoundingMode.HALF_UP).divide(new BigDecimal("100"), 6, RoundingMode.HALF_UP).add(new BigDecimal("1"));
    }

    public BigDecimal getAnnualInterestRate() {
        return annualInterestRate;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public float getYearsInFund() {
        return yearsInFund;
    }

    public BigDecimal getQuarterlyInterestMultiplier() {
        return quarterlyInterestMultiplier;
    }

    public BigDecimal getMonthlyInterestMultiplier() {
        return monthlyInterestMultiplier;
    }

    public BigDecimal getDailyInterestMultiplier() {
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
                io.print("The current year is: " + year);
                io.print("Current principal is: " + currentBalance);
                for (int j = 0; j < 4; j++) {
                    currentBalance = currentBalance.multiply(quarterlyInterestMultiplier).setScale(2, RoundingMode.HALF_UP);
                }
                io.print("Total anticipated interest is: " + (currentBalance.subtract(pastBalance).setScale(2, RoundingMode.HALF_UP)));
                io.print("Expected principal at the end of " + year + " is: " + currentBalance);
                io.print("");
                year++;
            } else if (reportRange.equals("monthly")) {
                for (int k = 0; k < 12; k++) {
                    switch (k) {
                        case 0:
                            io.print("The current month is January " + year);
                            break;
                        case 1:
                            io.print("The current month is February " + year);
                            break;
                        case 2:
                            io.print("The current month is March " + year);
                            break;
                        case 3:
                            io.print("The current month is April " + year);
                            break;
                        case 4:
                            io.print("The current month is May " + year);
                            break;
                        case 5:
                            io.print("The current month is June " + year);
                            break;
                        case 6:
                            io.print("The current month is July " + year);
                            break;
                        case 7:
                            io.print("The current month is August " + year);
                            break;
                        case 8:
                            io.print("The current month is September " + year);
                            break;
                        case 9:
                            io.print("The current month is October " + year);
                            break;
                        case 10:
                            io.print("The current month is November " + year);
                            break;
                        case 11:
                            io.print("The current month is December " + year);
                            break;
                        default:
                    }
                    pastBalance = currentBalance;
                    io.print("The current principal is: " + currentBalance);
                    currentBalance = currentBalance.multiply(monthlyInterestMultiplier).setScale(2, RoundingMode.HALF_UP);
                    io.print("Total anticipated interest is: " + (currentBalance.subtract(pastBalance).setScale(2, RoundingMode.HALF_UP)));
                    io.print("Expected principal at the end of this month is: " + currentBalance);
                    io.print("");
                }
                year++;
            } else if (reportRange.equals("daily")) {
                for (int l = 0; l < 365; l++) {
                    io.print("Today is day " + (l + 1) + ", " + year);
                    pastBalance = currentBalance;
                    io.print("The current principal is: " + currentBalance);
                    currentBalance = currentBalance.multiply(dailyInterestMultiplier).setScale(2, RoundingMode.HALF_UP);
                    io.print("Total anticipated interest by the end of day is: " + (currentBalance.subtract(pastBalance).setScale(2, RoundingMode.HALF_UP)));
                    io.print("Expected principal at the end of the day is: " + currentBalance);
                    io.print("");
                }
                year++;
            }

        }

        finalBalance = currentBalance;
    }

}
