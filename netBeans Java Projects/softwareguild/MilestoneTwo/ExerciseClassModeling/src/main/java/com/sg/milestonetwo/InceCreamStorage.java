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
public class InceCreamStorage {
    private String iceCreamFlavor, brand, makerLocation, ingredients;
    private int size, idNumber;
    private boolean isExpired;

    public InceCreamStorage(String iceCreamFlavor, String brand, String makerLocation, String ingredients, int size, int idNumber, boolean isExpired) {
        this.iceCreamFlavor = iceCreamFlavor;
        this.brand = brand;
        this.makerLocation = makerLocation;
        this.ingredients = ingredients;
        this.size = size;
        this.idNumber = idNumber;
        this.isExpired = isExpired;
    }

    public String getIceCreamFlavor() {
        return iceCreamFlavor;
    }

    public String getBrand() {
        return brand;
    }

    public String getMakerLocation() {
        return makerLocation;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getSize() {
        return size;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public boolean isIsExpired() {
        return isExpired;
    }

    public void setIsExpired(boolean isExpired) {
        this.isExpired = isExpired;
    }
    
}
