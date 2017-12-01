/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.two.variables;

/**
 *
 * @author Jesse
 */
public class MenuOfChampions {
    public static void main(String[] args) {
        String firstMenuItem = "Cheese Pizza";
        String secondMenuItem = "Pepperoni Pizza";
        String thirdMenuItem = "Veggie Pizza";
        double firstMenuPrice = 2.00;
        double secondMenuPrice = 2.75;
        double thirdMenuPrice = 2.50;
        
        System.out.println("              Welcome to Jesse's Generic Pizza Shop!");
        System.out.println("                      Today's Meni is...");
        System.out.print("                  " + firstMenuItem + "      $");
        System.out.printf("%.2f\n", firstMenuPrice);
        System.out.print("                  " + secondMenuItem + "   $");
        System.out.printf("%.2f\n", secondMenuPrice);
        System.out.print("                  " + thirdMenuItem + "      $");
        System.out.printf("%.2f\n", thirdMenuPrice);
        
    }
}
