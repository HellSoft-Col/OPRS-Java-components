/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author HellSoft
 */
public class RentSignDTO implements Serializable{
    private BigInteger rent_id;
    private String propertyAddress;
    private String propertyLocation;
    private Date rentalDate;
    private Date rentalTimeStart;
    private Date rentalTimeEnd;
    private BigDecimal rentProperty; 

    public RentSignDTO(BigInteger rent_id, String propertyAddress, String propertyLocation, Date rentalDate, Date rentalTimeStart, Date rentalTimeEnd, BigDecimal rentProperty) {
        this.rent_id = rent_id;
        this.propertyAddress = propertyAddress;
        this.propertyLocation = propertyLocation;
        this.rentalDate = rentalDate;
        this.rentalTimeStart = rentalTimeStart;
        this.rentalTimeEnd = rentalTimeEnd;
        this.rentProperty = rentProperty;
    }
    
    public BigInteger getRent_id() {
        return rent_id;
    }

    public void setRent_id(BigInteger rent_id) {
        this.rent_id = rent_id;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getPropertyLocation() {
        return propertyLocation;
    }

    public void setPropertyLocation(String propertyLocation) {
        this.propertyLocation = propertyLocation;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getRentalTimeStart() {
        return rentalTimeStart;
    }

    public void setRentalTimeStart(Date rentalTimeStart) {
        this.rentalTimeStart = rentalTimeStart;
    }

    public Date getRentalTimeEnd() {
        return rentalTimeEnd;
    }

    public void setRentalTimeEnd(Date rentalTimeEnd) {
        this.rentalTimeEnd = rentalTimeEnd;
    }

    public BigDecimal getRentProperty() {
        return rentProperty;
    }

    public void setRentProperty(BigDecimal rentProperty) {
        this.rentProperty = rentProperty;
    }
    
    
}
