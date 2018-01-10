/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.milestone3exerciseenums;

/**
 *
 * @author Jesse
 */
public class DaysUntilFriday {
     public int daysUntilFriday(DaysOfTheWeek day) {
        switch (day) {
            case SUNDAY:
                return 5;
            case MONDAY:
                return 4;
            case TUESDAY:
                return 3;
            case WEDNESDAY:
                return 2;
            case THURSDAY:
                return 1;
            case FRIDAY:
                return 0;
            case SATURDAY:
                return 6;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
