/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exerciserefactorfactorizor;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class ConsoleIO {
    private static Scanner myScanner = new Scanner(System.in);
    
    public String getString() {
        return myScanner.nextLine();
    }
    
    public int getNumber() {
        return Integer.parseInt(getString());
    }
}
