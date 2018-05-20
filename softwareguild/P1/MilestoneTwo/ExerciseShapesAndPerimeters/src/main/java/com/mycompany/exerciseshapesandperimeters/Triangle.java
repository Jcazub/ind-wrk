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
public class Triangle extends Shape {
    
    private double opposite, adjacent, hypotenuse;

    public Triangle(double opposite, double adjacent, double hypotenuse) {
        this.opposite = opposite;
        this.adjacent = adjacent;
        this.hypotenuse = hypotenuse;
    }
 
    @Override
    public double getArea() {
        return (adjacent*opposite)/2;
    }
    
    @Override
    public double getPerimeter() {
        return opposite+adjacent+hypotenuse;
    }
    
}
