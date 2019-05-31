/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
/**
 *
 * @author HellSoft
 */

@XmlRootElement
public class PropertyDTO implements Serializable{

    private String address;
    private String location;
    private BigDecimal rent;
    private BigInteger roomsNumber;
    private BigInteger type;
    
    private BigInteger owner_id;
    private BigInteger id;

    public PropertyDTO(BigInteger id, BigInteger owner_id, String address, String location, BigDecimal rent, BigInteger roomsNumber, BigInteger type) {
        this.id = id;
        this.owner_id = owner_id;
        this.address = address;
        this.location = location;
        this.rent = rent;
        this.roomsNumber = roomsNumber;
        this.type = type;
    }

    public PropertyDTO() {
    }
    

    public BigInteger getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(BigInteger owner_id) {
        this.owner_id = owner_id;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }
   
    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getRent() {
        return rent;
    }
    
    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public BigInteger getRoomsNumber() {
        return roomsNumber;
    }
    
    public void setRoomsNumber(BigInteger roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    public BigInteger getType() {
        return type;
    }
    
    public void setType(BigInteger type) {
        this.type = type;
    }
    
    
}
