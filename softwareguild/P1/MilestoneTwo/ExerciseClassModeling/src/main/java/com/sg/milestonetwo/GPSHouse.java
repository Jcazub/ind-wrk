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
public class GPSHouse {
    
    private double _latitude, _longitude;   
    private String _address, _city, _state;
    private int _zipcode;
    
    public GPSHouse(){  
    }
    
    public GPSHouse(double latitude, double longitude, String address, String city, String state, int zipcode) {
        this._latitude = latitude;
        this._longitude = longitude;
        this._address = address;
        this._city = city;
        this._state = state;
        this._zipcode = zipcode;
    }

    public double getLatitude() {
        return _latitude;
    }

    public double getLongitude() {
        return _longitude;
    }

    public String getAddress() {
        return _address;
    }

    public String getCity() {
        return _city;
    }

    public String getState() {
        return _state;
    }

    public int getZipcode() {
        return _zipcode;
    }

    
} 
