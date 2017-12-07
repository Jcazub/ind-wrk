/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.four.ifelse;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class FieldDay {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("What's your last name? ");
        String name = myScanner.nextLine();
        String team;
        
        if ("Baggins".compareToIgnoreCase(name) > 0) {
            team = "Red Dragons";
            System.out.println(name + ", you're on " + team + "!");
        } else if ("Baggins".compareToIgnoreCase(name) < 0 && "Dresden".compareToIgnoreCase(name) > 0) {
            team = "Dark Wizards";
            System.out.println(name + ", you're on " + team + "!");
        } else if ("Dresden".compareToIgnoreCase(name) < 0 && "Howl".compareToIgnoreCase(name) > 0) {
            team = "Moving Castles";
            System.out.println(name + ", you're on " + team + "!");
        } else if ("Howl".compareToIgnoreCase(name) < 0 && "Potter".compareToIgnoreCase(name) > 0) {
            team = "Golden Snitches";
            System.out.println(name + ", you're on " + team + "!");
        } else if ("Potter".compareToIgnoreCase(name) < 0 && "Vimes".compareToIgnoreCase(name) > 0) {
            team = "Night Guards";
            System.out.println(name + ", you're on " + team + "!");
        } else if ("Vimes".compareToIgnoreCase(name) < 0) {
            team = "Black Holes";
            System.out.println(name + ", you're on " + team + "!");
        }
        
        System.out.println("Good luck in the games!");
    }
}
