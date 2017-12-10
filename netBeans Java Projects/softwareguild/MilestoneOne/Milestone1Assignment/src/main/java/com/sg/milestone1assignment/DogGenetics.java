/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.milestone1assignment;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class DogGenetics {
    
    static Scanner myScanner = new Scanner(System.in);
    static Random randomizer = new Random();
    
    public static void main(String[] args) {
        
        // variable declarations
        String dogName;
        int totalPercentageRemaining = 100;
        int percentage = 0;
        int breedNameIndex;
        
        // ask user for dog name
        System.out.print("What is your dog's name? ");
        dogName = myScanner.nextLine();
        System.out.println("");
        
        System.out.println("Well then, I have this highly reliable report on " + dogName + "'s prestigious background right here.");
        System.out.println("");
        
        System.out.println(dogName + " is:");
        System.out.println("");
        
        // array of all possible dog breeds
        String[] dogBreeds = {"St. Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur", "King Doverman", "Golden Labrador", "Black Labrador", "Pitbull", "Husky", "Pomeranian"};
        String[] usedBreedName = new String[10];
        
        // sets all elements of the array to empty so no element reads null
        usedBreedName = setStringArrayToEmpty(usedBreedName);
        
        for (int i = 0, n = 5; i < n; i++) {
            
            // calculate remaining percentage available
            totalPercentageRemaining -= percentage;
     
            // runs until it comes upon a dog breed not used
            do {
                breedNameIndex = randomizer.nextInt(dogBreeds.length);
            } while (checkIfInArray(usedBreedName, dogBreeds[breedNameIndex]));
            
             // adds dog name to used dogs array
             usedBreedName[i] = dogBreeds[breedNameIndex];
            
            // if not last entry, recalculates a random percentage
            // if last entry, sets remaining percentage to the percentage of last entry
            if (i != n-1) {
                do {
                    percentage = calcPercentage(totalPercentageRemaining);
                } while (totalPercentageRemaining - percentage < n - i);
                
            } else {
                percentage = totalPercentageRemaining;
            }
            
            // prints out dog breed name and percentage
            System.out.println(percentage + "% " + dogBreeds[breedNameIndex]);
        } // close for loop         
    }
    
    //used to calculate a random percentage, with all percentages adding up to 100
    public static int calcPercentage(int remainingPercentage) {
        return randomizer.nextInt(remainingPercentage) + 1;
    }
    
    // checks if a string is contained inside an array
    public static boolean checkIfInArray(String[] arr, String str) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(str)) {
                return true;
            }
        }
        return false;
    }
    
    // sets all elements of a string array to the string "empty" 
    public static String[] setStringArrayToEmpty(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "empty";
        }
        return arr;
    }
    
}
