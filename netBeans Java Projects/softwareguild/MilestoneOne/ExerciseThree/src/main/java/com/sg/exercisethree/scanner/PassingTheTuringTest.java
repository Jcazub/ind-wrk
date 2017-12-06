/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercisethree.scanner;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class PassingTheTuringTest {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        
        
        
        
        
        
        System.out.print("What is your name? ");
        String name = myScanner.nextLine();
        System.out.print("Hey " + name + ", my name is Jesse. Nice to meet you! ");
        System.out.print("What is your favorite color " + name + "? ");
        String color = myScanner.nextLine();
        System.out.println("That's a neato color ," + color + "! I like blue myself.");
        System.out.print(" Since we are on a roll here, What's yout favorite dish! ");
        String favFood = myScanner.nextLine();
        System.out.print("mmmm " + favFood + " sounds delicious! Last, but not least, give me your faaavvvoorrite number! ");
        int favNumber = myScanner.nextInt();
        System.out.println(favNumber + "? Woah that's my favorite too! I guess man and machine do have a lot in common!");
        System.out.println("Well it was nice talking to you " + name + ". Hope to see you again soon! Caio!");
        
        
        
        
        
        
        
        
        
    }
}
