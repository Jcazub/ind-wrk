/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.three.scanner;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class MiniMadLibs {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        
        System.out.print("I need a noun: ");
        String noun = myScanner.nextLine();
        System.out.print("Now an adj: ");
        String adj = myScanner.nextLine();
        System.out.print("Another noun: ");
        String anotherNoun = myScanner.nextLine();
        System.out.print("And a number: ");
        String numberInput = myScanner.nextLine();
        int number = Integer.parseInt(numberInput);
        System.out.print("Another adj: ");
        String anotherAdj = myScanner.nextLine();
        System.out.print("A plural noun: ");
        String pluralNoun = myScanner.nextLine();
        System.out.print("Another one: ");
        String anotherPluralNoun = myScanner.nextLine();
        System.out.print("One more: ");
        String thirdPluralNoun = myScanner.nextLine();
        System.out.print("A verb (present tense): ");
        String presentTenseVerb = myScanner.nextLine();
        System.out.print("Same verb (past tense): ");
        String pastTenseVerb = myScanner.nextLine();
        System.out.println("");
        
        System.out.print(noun + ": the " + adj + " frontier. These are the voyages of the starship " + anotherNoun + ". Its " + number);
        System.out.println("-year mission: to explore strange " + anotherAdj + " " + pluralNoun + ",");
        System.out.print(" to seek out " + anotherAdj + " " + anotherPluralNoun + " and " + anotherAdj + " " + thirdPluralNoun);
        System.out.print(", to boldly " + presentTenseVerb + " where no one has " + pastTenseVerb + " before.");
        
        
        
    }
}
