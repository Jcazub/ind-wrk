/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercisesimplecalculator;

/**
 *
 * @author Jesse
 */
public class App {
    static ConsoleIO getUserInput = new ConsoleIO();
    static SimpleCalculator myCalc = new SimpleCalculator();
    
    public static void main(String[] args) {
        
        String operation;
        String operationSign = "";
        
        System.out.println("Welcome to my Simple Calculator App");
        System.out.println("This app only does simple calculations: addition, subtraction, mulitiplication, and division");
        
        
        do {
            
            System.out.println("Which simple calculation would you like to perform today?");
            System.out.print("You can either add, subtract, mulitply, or divide. (you can also close out of this program by typing in close): ");
            operation = getUserInput.getString();
            
            if (operation.equalsIgnoreCase("close")) {
                break;
            }

            if (operation.equalsIgnoreCase("add")) {
                getOperands();
                myCalc.add();
                operationSign = " + ";
            } else if (operation.equalsIgnoreCase("subtract")) {
                getOperands();
                myCalc.subtract();
                operationSign = " - ";
            } else if (operation.equalsIgnoreCase("multiply")) {
                getOperands();
                myCalc.multiply();
                operationSign = " * ";
            } else if (operation.equalsIgnoreCase("divide")) {
                getOperands();
                myCalc.divide();
                operationSign = " / ";
            } else {
                System.out.println("The operator you input was not valid.");
                continue;
            }

            printResult(myCalc.getResult(), operationSign);
           
            
        } while (!operation.equalsIgnoreCase("close"));
        
        System.out.println("Thank you for testing out myCalc");       
    }
    
    static public void getOperands() {
    System.out.print("The first number is?: ");
    myCalc.setOperand1(getUserInput.getNumber());
    System.out.print("The second number is?: ");
    myCalc.setOperand2(getUserInput.getNumber());
    }
    
    static public void printResult(int _result, String _operationSign) {
        System.out.println(myCalc.getOperand1() + _operationSign + myCalc.getOperand2() + " = " + _result);
    }
    
}


