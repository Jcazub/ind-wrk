/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exerciseshapesandperimeters;

/**
 *
 * @author Jesse
 */
public class Rectangle extends Shape {
    
    protected double width, height;
    
    Rectangle(double inputWidth, double inputHeight) {
        width = inputWidth;
        height = inputHeight;
    }
    
    @Override
    public double getArea() {
        return width*height;
    }
    
    @Override
    public double getPerimeter() {
        return (2*width) + (2*height); 
    }
    
}

