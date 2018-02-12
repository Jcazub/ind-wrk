/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringorders.ui;

/**
 *
 * @author Jesse
 */
public interface UserIO {
    
    void print(String message);
    
    void print(String message, boolean newLine);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt) throws InputErrorException;

    int readInt(String prompt, int min, int max) throws InputErrorException;

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);

    String readString(String prompt);
    
}
