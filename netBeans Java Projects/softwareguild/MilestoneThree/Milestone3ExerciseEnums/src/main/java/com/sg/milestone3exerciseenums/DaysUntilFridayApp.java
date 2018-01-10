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
public class DaysUntilFridayApp {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        DaysUntilFriday daysUntilFriday = new DaysUntilFriday();
    
        DaysOfTheWeek userInput = DaysOfTheWeek.valueOf(io.readString(
                "Enter today's date to find out how many days until friday: ")
                .toUpperCase());
        
        io.print("There are " + daysUntilFriday.daysUntilFriday(userInput) + " days until Friday." );
    }
            
}
