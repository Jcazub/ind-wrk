/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exerciserefactorfactorizor;

/**
 *
 * @author Jesse
 */
public class mainApp {
    
    public static void main(String[] args) {
        ConsoleIO getUserInput = new ConsoleIO();
        Factorizor myFactorizor = new Factorizor();
    
        System.out.print("What number do you want to factorize?: ");
        myFactorizor.factor(getUserInput.getNumber());
    }
    
}
