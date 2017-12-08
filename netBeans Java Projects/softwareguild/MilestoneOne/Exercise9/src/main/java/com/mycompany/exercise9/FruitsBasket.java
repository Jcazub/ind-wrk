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
public class FruitsBasket {
    public static void main(String[] args) {
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};
        int fruitCount = 0;
        int appleCount = 0;
        int orangeCount = 0;
        
        // Fruit sorting code goes here!
        for (int i = 0; i < fruit.length; i++, fruitCount++) {
            if (fruit[i].equals("Apple")) {
                appleCount++;
            } else if (fruit[i].equals("Orange")) {
                orangeCount++;
            }
        }
        
        String[] apples = new String[appleCount];
        String[] oranges = new String[orangeCount];
        
        for (int i = 0; i < apples.length; i++) {
            apples[i] = "Apple";
        }
        
        for (int i = 0; i < oranges.length; i++) {
            oranges[i] = "Orange";
        }
        
        System.out.println("Total # of Fruit in the Basket: " + fruitCount);
        System.out.println("Number of Apples: " + appleCount);
        System.out.println("Number of Oranges: " + orangeCount);

    }
}
