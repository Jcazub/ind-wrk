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
        String dogName;
        int totalPercentageRemaining = 100;
        int percentage = 0;
        int breedNameIndex;
        
        System.out.print("What is your dog's name? ");
        dogName = myScanner.nextLine();
        
        System.out.println("Well then, I have this highly reliable report on " + dogName + "'s prestigious background right here.");
        System.out.println("");
        
        System.out.println(dogName + " is:");
        String[] dogBreeds = {"St. Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur", "King Doverman", "Golden Labrador", "Black Labrador", "Pitbull", "Husky", "Pomeranian"};
        String[] usedBreedName = new String[10];
        usedBreedName = setStringArrayToEmpty(usedBreedName);
        // System.out.println(usedBreedName[5]);
        
        for (int i = 0, n = 4; i < n; i++) {
            
            totalPercentageRemaining -= percentage;
            
            do {
                percentage = calcPercentage(totalPercentageRemaining);
            } while (totalPercentageRemaining - percentage < n - i);
            
            do {
                breedNameIndex = randomizer.nextInt(dogBreeds.length);
            } while (checkIfInArray(usedBreedName, dogBreeds[breedNameIndex]));
            
            usedBreedName[i] = dogBreeds[breedNameIndex];
            System.out.println(percentage + " " + dogBreeds[breedNameIndex]); 
        }
        
        totalPercentageRemaining -= percentage;
        
        do {
            breedNameIndex = randomizer.nextInt(dogBreeds.length);
        } while (checkIfInArray(usedBreedName, dogBreeds[breedNameIndex]));
       
        System.out.println(totalPercentageRemaining + " " + dogBreeds[breedNameIndex]);     
    }
    
    public static int calcPercentage(int remainingPercentage) {
        return randomizer.nextInt(remainingPercentage) + 1;
    }
    
    public static boolean checkIfInArray(String[] arr, String str) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(str)) {
                return true;
            }
        }
        return false;
    }
    
    public static String[] setStringArrayToEmpty(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "empty";
        }
        return arr;
    }
    
}
