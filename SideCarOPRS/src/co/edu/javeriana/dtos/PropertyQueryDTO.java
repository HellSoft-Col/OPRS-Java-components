/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.dtos;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HellSoft
 */


public class PropertyQueryDTO implements Serializable{
    private String location; 
    private int propertyType;
    private int roomsNumber;
    private float minimalRent;
    private float maximalRent;
    private String cedulaProp;

    public PropertyQueryDTO() {
        this.cedulaProp = null;
        this.minimalRent = -1;
        this.maximalRent = -1;
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

    public String getCedulaProp() {
        return cedulaProp;
    }
    
    public void setCedulaProp(String cedulaProp) {
        this.cedulaProp = cedulaProp;
    }
   
}
