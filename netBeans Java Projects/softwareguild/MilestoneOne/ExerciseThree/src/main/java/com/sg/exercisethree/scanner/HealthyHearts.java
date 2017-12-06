/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercisethree.scanner;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class HealthyHearts {
    public static void main(String[] args) {
        Scanner ageInput = new Scanner(System.in); 
        int age;
        int heartRateMax;
        int heartRateUpperRange;
        int heartRateLowerRange;
        
        
        System.out.print("What is your age sir/madam? ");
        age = ageInput.nextInt();
        heartRateMax = 220 - age;
        System.out.println("Your maximum heart rate should be " + heartRateMax + ". ");
        heartRateUpperRange = (heartRateMax * 85)/100;
        heartRateLowerRange = heartRateMax/2;
        System.out.println("A good target for your heart rate would be between " + heartRateLowerRange + " and " + heartRateUpperRange + ".");
        
        
    }
}
