/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fors;

/**
 *
 * @author Jesse
 */
public class DifferentKettleOfFish {
    public static void main(String[] args) {

//        int fish = 1;
//        while(fish < 10){
//            if(fish == 3){
//                System.out.println("RED fish!");
//            }else if(fish == 4){
//                System.out.println("BLUE fish!");
//            } else{
//                System.out.println(fish + " fish!");
//            }
//
//            fish++;
//        }
        
        // Refactoring the code into a for loop, we initialized the fish variable in the conditional
        // as well as incrementing fish in the conditional instead of inside the code block
        for (int fish = 1; fish < 10; fish++) {
            if(fish == 3){
                System.out.println("RED fish!");
            }else if(fish == 4){
                System.out.println("BLUE fish!");
            } else{
                System.out.println(fish + " fish!");
            }
        }

    }
}
