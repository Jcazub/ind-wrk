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
public class CoinFlipper {
    public static void main(String[] args) {
        Random randomizer = new Random();
        Boolean coinFlip = randomizer.nextBoolean();
        
        System.out.println("Ready, Set, Flip....!!");
        if (coinFlip == true) {
            System.out.println("You got HEADS!");
        } else {
            System.out.println("You got TAILS!");
        }
    }
}
