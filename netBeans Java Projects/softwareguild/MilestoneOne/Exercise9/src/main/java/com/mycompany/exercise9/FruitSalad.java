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
public class FruitSalad {
    public static void main(String[] args) {
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};
        int appleCount = 0;
        int applesInFruitSalad = 0;
        int tomatoCount = 0;
        int orangeCount = 0;
        int orangesInFruitSalad = 0;
        int berryCount = 0;
        int berriesInFruitSalad = 0;
        
        String[] fruitSalad = new String[12];
//        String[] apples;
//        String[] oranges;
//        String[] tomatoes;
//        String[] berries;

     
        for (int i = 0, j = 0; i < fruit.length; i++) {
            if (fruit[i].contains("Apple")) {        
                appleCount++;
                if (appleCount < 3) {
                    fruitSalad[j] = fruit[i];
                    j++;
                    applesInFruitSalad++;
                }
            } else if (fruit[i].contains("Tomato")) {
                tomatoCount++;
            } else if (fruit[i].contains("Orange")) {               
                orangeCount++;
                if (orangeCount < 2) {
                    fruitSalad[j] = fruit[i];
                    j++;
                    orangesInFruitSalad++;
                }
            } else {
                fruitSalad[j] = fruit[i];
                berryCount++;
                j++;
                berriesInFruitSalad++;
            }
            
            if (j == fruitSalad.length) {
                break;
            }
        }
        
        
        
        System.out.println("Apples in fruit salad: " + applesInFruitSalad);
        //System.out.println(tomatoCount);
        System.out.println("Oranges in fruit salad: " + orangesInFruitSalad);
        System.out.println("berries in fruit salad: " + berriesInFruitSalad);
        
        for (int k = 0; k < fruitSalad.length; k++) {
           System.out.print(fruitSalad[k] + " "); 
        }
        
        
        // Code Recipe for fruit salad should go here!
        
    }
}
