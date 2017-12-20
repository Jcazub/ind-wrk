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
public class AirTrafficAirplane {
    private double xCoordinate, yCoordinate, ZCoordinate, startingPoint, endingPoint;
    private String planeType, planeCompany;
    private int planeIdentificationNumber;
    
    public AirTrafficAirplane(double _startingPoint, String _planeType, String _planeCompany, int _planeIdentificationNumber) {
        this.startingPoint = _startingPoint;
        this.planeType = _planeType;
        this.planeCompany = _planeCompany;
        this.planeIdentificationNumber = _planeIdentificationNumber;
        
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public double getZCoordinate() {
        return ZCoordinate;
    }

    public double getStartingPoint() {
        return startingPoint;
    }

    public double getEndingPoint() {
        return endingPoint;
    }

    public String getPlaneType() {
        return planeType;
    }

    public String getPlaneCompany() {
        return planeCompany;
    }

    public int getPlaneIdentificationNumber() {
        return planeIdentificationNumber;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void setZCoordinate(double ZCoordinate) {
        this.ZCoordinate = ZCoordinate;
    }

    public void setEndingPoint(double endingPoint) {
        this.endingPoint = endingPoint;
    }
    
}  

