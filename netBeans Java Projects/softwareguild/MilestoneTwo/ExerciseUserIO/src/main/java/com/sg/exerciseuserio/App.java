/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exerciseuserio;

/**
 *
 * @author Jesse
 */
public class App {
    static MainUserIO myUserIO = new MainUserIO();
    static SimpleCalculator myCalc = new SimpleCalculator();
    
    public static void main(String[] args) {
        
        String operation;
        String operationSign = "";
        
        myUserIO.print("Welcome to my Simple Calculator App", true);
        myUserIO.print("This app only does simple calculations: addition, subtraction, mulitiplication, and division", true);
        
        
        do {
            
            myUserIO.print("Which simple calculation would you like to perform today?", true);
            operation = myUserIO.readString("You can either add, subtract, mulitply, or divide. (you can also close out of this program by typing in close): ");
            
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
        
        myUserIO.print("Thank you for testing out myCalc", true);       
    }
    
    static public void getOperands() {
    myCalc.setOperand1(myUserIO.readInt("The first number is?: "));
    myCalc.setOperand2(myUserIO.readInt("The second number is?: "));
    }
    
    static public void printResult(int _result, String _operationSign) {
        myUserIO.print(myCalc.getOperand1() + _operationSign + myCalc.getOperand2() + " = " + _result, true);
    }
    
}


