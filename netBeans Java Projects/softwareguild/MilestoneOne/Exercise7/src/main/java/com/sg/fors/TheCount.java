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
public class TheCount {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String numberInput;
        int start;
        int stop;
        int increment;
        int count = 0;
        
        System.out.println("*** I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU! ***");
        System.out.print("Start at: ");
        numberInput = myScanner.nextLine();
        start = Integer.parseInt(numberInput);
        System.out.print("Stop at: ");
        numberInput = myScanner.nextLine();
        stop = Integer.parseInt(numberInput);
        System.out.print("Count by: ");
        numberInput = myScanner.nextLine();
        increment = Integer.parseInt(numberInput);
        System.out.println("");
        
        for(int i = start; i <= stop; i += increment) {
            System.out.print(i + " ");
            if ((count+1)%3 == 0) {
                System.out.println("- Ah ah ah!");
            }
            count++;
        }
    }
}
