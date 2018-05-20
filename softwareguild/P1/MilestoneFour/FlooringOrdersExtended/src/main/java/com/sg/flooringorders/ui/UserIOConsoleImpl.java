/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders.ui;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class UserIOConsoleImpl implements UserIO {
    
    private final Scanner sc = new Scanner(System.in); 
    
    @Override
    public void print(String message) {
        System.out.println(message); 
    }
    
    @Override
    public void print(String message, boolean newLine) {
        if (newLine == false) {
            System.out.print(message);
        } else {
            System.out.println(message);
        }
    }

    @Override
    public double readDouble(String prompt) {
        double d;
        print(prompt);
        d = Double.parseDouble(sc.nextLine());
        return d;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double d;
        do {
            print(prompt);
            d = Double.parseDouble(sc.nextLine());
        } while (!(d >= min && d <= max));
        return d;
    }

    @Override
    public float readFloat(String prompt) {
        float f;
        print(prompt);
        f = Float.parseFloat(sc.nextLine());
        return f;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float f;
        do {
            print(prompt);
            f = Float.parseFloat(sc.nextLine());
        } while (!(f >= min && f <= max));
        return f;
    }

    @Override
    public int readInt(String prompt) throws InputErrorException {
        int n;
        print(prompt);
        try {
            n = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            throw new InputErrorException("Expected a number");
        }
        return n;
    }

    @Override
    public int readInt(String prompt, int min, int max) throws InputErrorException {
        int n;
        boolean hasError = false;
        do {
            print(prompt);
            try {
                n = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                throw new InputErrorException("Expected a number");
            }
            
        } while (!(n >= min && n <= max));
        return n;
    }

    @Override
    public long readLong(String prompt) {
        long l;
        print(prompt);
        l = Long.parseLong(sc.nextLine());
        return l;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long l;
        do {
            print(prompt);
            l = Long.parseLong(sc.nextLine());
        } while (!(l >= min && l <= max));
        return l;
    }

    @Override
    public String readString(String prompt) {
        String s;
        print(prompt);
        s = sc.nextLine();
        return s;     
    }
}
