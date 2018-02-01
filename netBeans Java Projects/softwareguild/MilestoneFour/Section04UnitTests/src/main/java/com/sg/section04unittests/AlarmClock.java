package com.sg.section04unittests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jesse
 */
public class AlarmClock {
    // Given a day of the week encoded as 
    // 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a boolean indicating 
    // if we are on vacation, return a String of the form "7:00" 
    // indicating when the alarm clock should ring. Weekdays, the 
    // alarm should be "7:00" and on the weekend it should be "10:00". 
    // Unless we are on vacation -- then on weekdays it should be 
    // “10:00" and weekends it should be "off". 
    //
    // alarmClock(1, false) → "7:00"
    // alarmClock(5, false) → "7:00"
    // alarmClock(0, false) → "10:00"
    public String alarmClock(int day, boolean vacation) throws Section04UnitTestException {
        if (day < 0 || day > 6) {
            throw new Section04UnitTestException("Day out of bounds");
        }
        
        if (day >= 1 && day <= 5 ) {
            if (vacation) {
                return "10:00";
            } else {
                return "7:00";
            }
        } else {
            if (vacation) {
                return "OFF";
            } else {
                return "10:00";
            }
        }
    }

}
