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
public class InventoryCar {
    private String carModel, modelCompany, color;
    private double mileage, fuelEffiecency;
    private int yearOfManufacture;
    private boolean inACrash, waterDamaged;

    public InventoryCar(String carModel, String modelCompany, String color, double fuelEffiecency, int yearOfManufacture) {
        this.carModel = carModel;
        this.modelCompany = modelCompany;
        this.color = color;
        this.fuelEffiecency = fuelEffiecency;
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getModelCompany() {
        return modelCompany;
    }

    public String getColor() {
        return color;
    }

    public double getMileage() {
        return mileage;
    }

    public double getFuelEffiecency() {
        return fuelEffiecency;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public boolean isInACrash() {
        return inACrash;
    }

    public boolean isWaterDamaged() {
        return waterDamaged;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setInACrash(boolean inACrash) {
        this.inACrash = inACrash;
    }

    public void setWaterDamaged(boolean waterDamaged) {
        this.waterDamaged = waterDamaged;
    }
    
    
}
