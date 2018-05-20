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
public class GameCar {
    private String carModel, driver, decal, color;
    private int zeroTo60, maxSpeed, speed, gear, carHealth, steeringDirectionRadius;

    public GameCar(String carModel, String driver, String decal, String color) {
        this.carModel = carModel;
        this.driver = driver;
        this.decal = decal;
        this.color = color;
        if (carModel.equals("Ford Focus")) {
            this.maxSpeed = 50;
            this.carHealth = 110;
            this.zeroTo60 = 6;
        }
        
        
    }

    public String getCarModel() {
        return carModel;
    }

    public String getDriver() {
        return driver;
    }

    public String getDecal() {
        return decal;
    }

    public String getColor() {
        return color;
    }

    public int getZeroTo60() {
        return zeroTo60;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getSpeed() {
        return speed;
    }

    public int getGear() {
        return gear;
    }

    public int getCarHealth() {
        return carHealth;
    }

    public int getSteeringDirectionRadius() {
        return steeringDirectionRadius;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public void setSteeringDirectionRadius(int steeringDirectionRadius) {
        this.steeringDirectionRadius = steeringDirectionRadius;
    }
    
    
    
    
}

