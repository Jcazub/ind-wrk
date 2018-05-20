/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.milestonetwo;

/**
 *
 * @author Jesse
 */
public class IceCreamControlSystem {
    private final String iceCreamFlavors = "Vanilla, Chocolate, Strawberry";
    private final String ingredient1 = "vanilla extract"; 
    private final String ingredient2 = "coco beans"; 
    private final String ingredient3 = "strawberry puree";
    private boolean isThereMilk;
    private int numberOfMilkGallons = 10;

    public String getIceCreamFlavors() {
        return iceCreamFlavors;
    }
    
    public void makeIceCream(String iceCreamFlavor) {
        switch (iceCreamFlavor) {
            case "vanilla":
                chillIceCreamIngredients(mixIngredientWithMilk(ingredient1));
                break;
            case "chocolate":
                chillIceCreamIngredients(mixIngredientWithMilk(ingredient2));
                break;
            case "strawberry":
                chillIceCreamIngredients(mixIngredientWithMilk(ingredient3));
                break;
            default:
                break;
        }
    }
    
    private String mixIngredientWithMilk(String ingredient) {
        String mixedIngredient = "";
        if(isThereMilk == true) {
            numberOfMilkGallons--;
            mixedIngredient = ingredient1 + " milk added";         
        }
        
        if (numberOfMilkGallons <= 0) {
            isThereMilk = false;
        }
        return mixedIngredient;
    }
    
    private void chillIceCreamIngredients(String mixedIngredients) {
        if (mixedIngredients.contains(" milk added")) {
            //chills ice cream to be served
        }
        
    }
    
    public void restockMilk(int validIdNumber){
        if (validIdNumber == 12345) {
            isThereMilk = true;
            numberOfMilkGallons = 10;
        }
    }
 
    private void storeIceCream() {
        //stores ice cream
    }
}
