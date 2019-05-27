/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.dtos;

import java.io.Serializable;

/**
 *
 * @author SANTI
 */
public class PropertyQueryDTO implements Serializable{
    private String location; 
    private int propertyType;
    private int roomsNumber;
    private float minimalRent;
    private float maximalRent;

    public PropertyQueryDTO() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(int propertyType) {
        this.propertyType = propertyType;
    }

    public int getRoomsNumber() {
        return roomsNumber;
    }

    public void setRoomsNumber(int roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    public float getMinimalRent() {
        return minimalRent;
    }

    public void setMinimalRent(float minimalRent) {
        this.minimalRent = minimalRent;
    }

    public float getMaximalRent() {
        return maximalRent;
    }

    public void setMaximalRent(float maximalRent) {
        this.maximalRent = maximalRent;
    }
    
    
}
