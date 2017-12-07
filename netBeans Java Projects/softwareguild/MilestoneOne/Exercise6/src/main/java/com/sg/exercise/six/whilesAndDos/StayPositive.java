/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.six.whilesAndDos;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class StayPositive {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("What number should I count down from?: ");
        String numberInput = myScanner.nextLine();
        int number = Integer.parseInt(numberInput);
        int count = 0;
        
        System.out.println("Here goes!");
        System.out.println("");
        
        while (number >= 0) {
            System.out.print(number+" ");
             if (count == 9){
               count = -1;
               System.out.println("");
            }
            number--;
            count++;
        }
        System.out.println("");
        System.out.println("Whew, better stop there...!");
    }
  
}
