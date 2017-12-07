/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercisefive.random;

import java.util.Random;

/**
 *
 * @author Jesse
 */
public class ALittleChaos {
    
    public static void main(String[] args) {

        Random randomizer = new Random();

        System.out.println("Random can make integers: " + randomizer.nextInt());
        System.out.println("Or a double: " + randomizer.nextDouble());
        System.out.println("Or even a boolean: " + randomizer.nextBoolean());

        int num = randomizer.nextInt(100);

        System.out.println("You can store a randomized result: " + num);
        System.out.println("And use it over and over again: " + num + ", " + num);

        System.out.println("Or just keep generating new values");
        System.out.println("Here's a bunch of numbers from 0 - 100: ");

        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.println(randomizer.nextInt(101));
        
        
//        The above can also be expressed using the expressions below
//        System.out.print(randomizer.nextInt(50) + 50 + ", ");
//        System.out.print(randomizer.nextInt(50) + 50 + ", ");
//        System.out.print(randomizer.nextInt(50) + 50 + ", ");
//        System.out.print(randomizer.nextInt(50) + 50 + ", ");
//        System.out.print(randomizer.nextInt(50) + 50 + ", ");
//        System.out.println(randomizer.nextInt(50) + 50);
  
    }
}
