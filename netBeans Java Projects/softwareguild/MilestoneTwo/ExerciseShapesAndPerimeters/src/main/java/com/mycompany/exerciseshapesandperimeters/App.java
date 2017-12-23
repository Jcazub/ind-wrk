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
public class App {
    public static void main(String[] args) {
         Square _square = new Square(5);
         Rectangle _rectangle = new Rectangle(5,10);
         Triangle _triangle = new Triangle(2,3,4);
         Circle _circle = new Circle(5);
         
         prints("The area and perimeter of ","rectangle: " ,_rectangle );
         prints("The area and perimeter of ","square: " ,_square );
         prints("The area and perimeter of ","triangle: " ,_triangle );
         prints("The area and perimeter of ","circle: " ,_circle );
         
    }


    public static void prints(String s1, String s2, Shape shape) {
        System.out.println(s1 + s2 + shape.getArea() + " " + shape.getPerimeter());
    }
}
