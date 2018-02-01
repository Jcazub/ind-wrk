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
public class RotateLeft {
    // Given an array of ints, return an array with the elements 
    // “rotated left" so {1, 2, 3} yields {2, 3, 1}. 
    //
    // rotateLeft({1, 2, 3}) -> {2, 3, 1}
    // rotateLeft({5, 11, 9}) -> {11, 9, 5}
    // rotateLeft({7, 0, 0}) -> {0, 0, 7}
    public int[] rotateLeft(int[] numbers) throws Section04UnitTestException {
        if (numbers == null) {
            throw new Section04UnitTestException("Cannot rotate null array");
        }
        
        int[] rotated = new int[numbers.length];
        for (int i = 0; i < rotated.length; i++) {
            
            if (i == (rotated.length - 1)) {
                rotated[rotated.length - 1] = numbers[0]; 
            } else {
                rotated[i] = numbers[i+1];
            }
            
        }
        
        return rotated;
    }
}
