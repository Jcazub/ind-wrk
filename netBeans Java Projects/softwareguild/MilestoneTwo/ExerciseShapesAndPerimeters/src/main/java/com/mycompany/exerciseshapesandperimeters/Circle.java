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
public class Circle extends Shape {
    
    private final double pi = 3.14159265359;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return pi*(radius*radius);
    }
    
    @Override
    public double getPerimeter() {
        return 2*pi*radius;
    }
}
