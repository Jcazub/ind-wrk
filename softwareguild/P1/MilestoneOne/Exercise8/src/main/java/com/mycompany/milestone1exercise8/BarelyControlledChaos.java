/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.milestone1exercise8;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jesseazubuike
 */
public class BarelyControlledChaos {
    
    static Scanner myScanner = new Scanner(System.in);
    static Random randomizer = new Random();
            
    public static void main(String[] args) {

        String color = getRandomColor(); // call color method here 
        String animal = getRandomAnimal(); // call animal method again here 
        String colorAgain = getRandomColor(); // call color method again here 
        int weight = getRandomNumber(5,200); // call number method, 
            // with a range between 5 - 200 
        int distance = getRandomNumber(10,20); // call number method, 
            // with a range between 10 - 20 
        int number = getRandomNumber(10000,20000); // call number method, 
            // with a range between 10000 - 20000 
        int time = getRandomNumber(2,6); // call number method, 
            // with a range between 2 - 6            
    
        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal 
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over " 
            + number + " " + colorAgain + " poppies for nearly " 
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, " 
            + "let me tell you!");
    } 
    
    // ??? Method 1 ???            
    public static String getRandomColor(){
        int randomColorNum  = randomizer.nextInt(5);
        String color = "";
        
        switch (randomColorNum) {
            case 0:
                color = "red";
                break;
            case 1:
                color = "red";
                break;
            case 2:
                color = "red";
                break;
            case 3:
                color = "red";
                break;
            case 4:
                color = "red";
                break;
            default:
                
        }
        return color;
    }
    // ??? Method 2 ??? 
    public static String getRandomAnimal(){
        int randomAnimalNum = randomizer.nextInt(5);
        String animal = "";
        
        switch (randomAnimalNum) {
            case 0:
                animal = "octopus";
                break;
            case 1:
                animal = "cat";
                break;
            case 2:
                animal = "robin";
                break;
            case 3:
                animal = "cheetah";
                break;
            case 4:
                animal = "rhino";
                break;
            default:
                
        }
        return animal;
    }
    // ??? Method 3 ??? 
    public static int getRandomNumber(int min, int max) {
        return randomizer.nextInt(max + 1 - min) + min;
    }
    
}
