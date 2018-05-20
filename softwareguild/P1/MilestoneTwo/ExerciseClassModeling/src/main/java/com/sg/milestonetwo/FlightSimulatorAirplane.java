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
public class FlightSimulatorAirplane {
    private double xCoordinate, yCoordinate, zCoordinate, timeInAir, destination;
    private int topSpeed, speed;
    private String planeModel, driver;
    
    public FlightSimulatorAirplane(double destination, int topSpeed, String planeModel, String driver) {
        this.destination = destination;
        this.topSpeed = topSpeed;
        this.planeModel = planeModel;
        this.driver = driver;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void setzCoordinate(double zCoordinate) {
        this.zCoordinate = zCoordinate;
    }

    public void setTimeInAir(double timeInAir) {
        this.timeInAir = timeInAir;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public double getzCoordinate() {
        return zCoordinate;
    }

    public double getTimeInAir() {
        return timeInAir;
    }

    public double getDestination() {
        return destination;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public int getSpeed() {
        return speed;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public String getDriver() {
        return driver;
    }
    
    
}
