/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.helloworld;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class Hello {
    public static void main(String [] args) {
        Scanner myScanner = new Scanner(System.in);
        String name = "";
        System.out.println("What is your name, Hero?");
        name = myScanner.nextLine();
        System.out.println("Welcome hero: " + name);
        int age;
        System.out.println("What is your age, " + name + "?");
        String ageInput = myScanner.nextLine();
        
        age = Integer.parseInt(ageInput);
        
        System.out.println("You're age is : " + age);
        
        // declare an int called counter
        int counter;
        int operand2;
        
        // now I'm assigning a number to counter
        counter = 7;       
        operand2 = 2;
        
        // declare a boolean variable called isDone
        boolean isDone;
        
        // now assign false to isDone
        isDone = false;
        
        counter += operand2;
                
        int result = 20 % operand2;
        
        // +, -, /, and % are all arithmetic operators
        
        
        System.out.println("Hello, World!");
    }
}
