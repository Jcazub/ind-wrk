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
public class SimpleCalculator {
    private int operand1, operand2, result;
    
    public void add() {
       result = operand1 + operand2; 
    }
    
    public void subtract() {
       result = operand1 - operand2;
    }
    
    public void multiply() {
       result = operand1 * operand2;
    }
    
    public void divide() {
       result = operand1 / operand2;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public int getOperand1() {
        return operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public int getResult() {
        return result;
    }

}
