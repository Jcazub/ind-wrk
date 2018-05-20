/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

/**
 *
 * @author Jesse
 */
public class App {
    public static void main(String[] args) {
        MakePi makePi = new MakePi();
        
        int[] test = makePi.makePi(3);
        
        for (int testInt : test) {
            System.out.println(testInt);
        }
        
        int[] expectedResult = {3,1,4};
        
        for (int result : expectedResult) {
            System.out.println(result);
        }
        
        if (test == expectedResult) {
            System.out.println("true");
        } else {
            System.out.println("Not true");
        }
    }
}
