/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exerciserefactorfactorizor;

/**
 *
 * @author Jesse
 */
public class Factorizor {
    private int factorsAdded, factorsCount;
    private int[] factors = new int[100];
    
    public void factor(int number) {

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
