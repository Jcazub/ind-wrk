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
public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String numberInput;
        int number;
        int count = 0;
        System.out.print("How much units fizzing and buzzing do you need in your life?: ");
        numberInput = myScanner.nextLine();
        number = Integer.parseInt(numberInput);
        
        for (int i = 0; i < 100; i++) {
            if (i == 0) {
                System.out.println(i);
            } else if (i%3 == 0 && i%5 != 0) {
                System.out.println("Fizz");
                count++;
            } else if (i%3 != 0 && i%5 == 0){
                System.out.println("Buzz");
                count++;
            } else if (i%3 == 0 && i%5 == 0) {
                System.out.println("FizzBuzz");
                count++;
            } else {
                System.out.println(i);
            }
            
            if (count == number){
                System.out.println("TRADITION!");
                break;
            }
        }
    }
}
