/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fors;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class ForTimes {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Which times table shall I recite?: ");
        String numberInput = myScanner.nextLine();
        int number = Integer.parseInt(numberInput);
        
        for (int i = 1; i <= 15; i++) {
            System.out.println(i + " * " + number + " is: " + (i*number));
        }
    }
    
    
}
