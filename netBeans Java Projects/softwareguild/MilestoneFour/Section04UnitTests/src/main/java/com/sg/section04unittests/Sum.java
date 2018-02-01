/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

/**
 *
 * @author Jesse
 */
public class Sum {
    // Given an array of ints, return the sum of all the elements. 
    //
    // sum({1, 2, 3}) -> 6
    // sum({5, 11, 2}) -> 18
    // sum({7, 0, 0}) -> 7
    public int sum(int[] numbers) throws Section04UnitTestException {
        if (numbers == null) {
            throw new Section04UnitTestException("Cannot compute sum for null array.");
        }
        
        int sum = 0;
        
        for (int i : numbers) {
            sum += i;
        }
        return sum;
    }
}
