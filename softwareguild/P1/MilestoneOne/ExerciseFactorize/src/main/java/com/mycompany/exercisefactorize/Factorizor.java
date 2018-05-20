/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercisefactorize;

import java.util.Scanner;

/**
 *
 * @author jesseazubuike
 */
public class Factorizor {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("What number would you like to factor?: ");
        String numberInput = myScanner.nextLine();
        int number = Integer.parseInt(numberInput);
        int[] factors = new int[100];
        int factorsAdded = 0;
        int factorsCount = 0;
        
        System.out.println("The factors of " + number + " are:");
        
        for (int i = 1, j = 0, newNumber = number; i <= number; i++) {
            
            if (i == 1) {
                factors[j] = i;
                j++;
            }
                        
            while (newNumber%i == 0 && i != 1) {
                factors[j] = i;
                j++;
                newNumber /= i;
                
            }
        }
        
        for (int k = 0; k < factors.length; k++) {
            if (factors[k] == 0) {               
                break;
            }
            
            factorsAdded += factors[k];
            factorsCount++;
            System.out.println(factors[k] + " ");                       
        }
        
        if (factorsAdded == number) {
            System.out.println(number + " is a perfect number.");
        } else {
            System.out.println(number + " is not a perfect number.");
        }
        
        if (factorsCount < 3) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }
    
}
