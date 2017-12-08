/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercise9;

/**
 *
 * @author jesseazubuike
 */
public class SimpleSort {
     public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};

        int[] wholeNumbers = new int[24];

        for (int i = 0, j = 0, k = 0; i < wholeNumbers.length; i++) { 
            
            if (j < firstHalf.length && k < secondHalf.length) {
               if (firstHalf[j] < secondHalf[k]) {
                    wholeNumbers[i] = firstHalf[j];
                    j++;                    
                } else if (firstHalf[j] > secondHalf[k]) {
                    wholeNumbers[i] = secondHalf[k];
                    k++;                  
                } 
            } else if (j < firstHalf.length) {
                wholeNumbers[i] = firstHalf[j];
            } else {
                wholeNumbers[i] = secondHalf[k];
            }             
        }
                
                
        for (int l = 0; l < wholeNumbers.length; l++) {
            System.out.println(wholeNumbers[l]);
        }
    }

        // Sorting code should go here!
}
