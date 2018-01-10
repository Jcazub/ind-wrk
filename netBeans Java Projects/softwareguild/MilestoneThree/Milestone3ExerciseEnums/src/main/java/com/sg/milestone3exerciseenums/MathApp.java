/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.milestone3exerciseenums;

/**
 *
 * @author Jesse
 */
public class MathApp {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        IntMath intMath = new IntMath();
        boolean keepGoing = true;
        
        do {
            MathOperator operation = MathOperator.valueOf(io.readString("Enter an operation: ").toUpperCase());
            int operand1 = io.readInt("Enter the first operand: ");
            int operand2 = io.readInt("Enter the second operand: ");

            io.print(operand1 + " " + operation + " " + operand2 + " = " +
            intMath.calculate(operation, operand1, operand2));
            
            String another = io.readString("Would you like to perform another operation? (y/n): ");
            
            if (!another.equalsIgnoreCase("y")) {
                keepGoing = false;
            }
        } while (keepGoing);
        
        
        io.print("Closing calculator...");
    }
}
