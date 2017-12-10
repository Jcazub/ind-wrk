/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.milestone1assignment;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class HealthyHearts {
     public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String ageInput;
        int age, heartRateMax, heartRateUpperRange, heartRateLowerRange;

        System.out.print("What is your age sir/madam? ");
        ageInput = myScanner.nextLine();
        age = Integer.parseInt(ageInput);
        heartRateMax = 220 - age;
        System.out.println("Your maximum heart rate should be " + heartRateMax + ". ");
        heartRateUpperRange = (heartRateMax * 85)/100;
        heartRateLowerRange = heartRateMax/2;
        System.out.println("A good target for your heart rate would be between " + heartRateLowerRange + " and " + heartRateUpperRange + ".");
    
    }
}
