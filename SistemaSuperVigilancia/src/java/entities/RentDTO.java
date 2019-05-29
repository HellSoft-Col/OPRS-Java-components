/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author LICHO
 */
public class RentDTO {
    private BigDecimal id;
    private Date rentalDate;
    private Date rentalTimeStart;
    private Date rentalTimeEnd;
    private double rentProperty;
    private String state;
    private String costumerName;
    private String costumerLastName;
    private String customerNdi;
    private String customerEmail;
    private String propertyType;
    private String propertyAddress;
    private BigInteger propertyRooms;
    private String propertyLocation;
    private String ownerName;
    private String ownerLastName;
    private String ownerNdi;
    private String ownerEmail;

    public RentDTO() {
    }

    public RentDTO(BigDecimal id, Date rentalDate, Date rentalTimeStart, Date rentalTimeEnd, 
            double rentProperty, String state, String costumerName, String costumerLastName, 
            String customerNdi, String customerEmail, String propertyType, String propertyAddress, 
            BigInteger propertyRooms, String propertyLocation, String ownerName, String ownerLastName, 
            String ownerNdi, String ownerEmail) {
        this.id = id;
        this.rentalDate = rentalDate;
        this.rentalTimeStart = rentalTimeStart;
        this.rentalTimeEnd = rentalTimeEnd;
        this.rentProperty = rentProperty;
        this.state = state;
        this.costumerName = costumerName;
        this.costumerLastName = costumerLastName;
        this.customerNdi = customerNdi;
        this.customerEmail = customerEmail;
        this.propertyType = propertyType;
        this.propertyAddress = propertyAddress;
        this.propertyRooms = propertyRooms;
        this.propertyLocation = propertyLocation;
        this.ownerName = ownerName;
        this.ownerLastName = ownerLastName;
        this.ownerNdi = ownerNdi;
        this.ownerEmail = ownerEmail;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public double getRentProperty() {
        return rentProperty;
    }

    public void setRentProperty(double rentProperty) {
        this.rentProperty = rentProperty;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }

    public String getCostumerLastName() {
        return costumerLastName;
    }

    public void setCostumerLastName(String costumerLastName) {
        this.costumerLastName = costumerLastName;
    }

    public String getCustomerNdi() {
        return customerNdi;
    }

    public void setCustomerNdi(String customerNdi) {
        this.customerNdi = customerNdi;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public BigInteger getPropertyRooms() {
        return propertyRooms;
    }

    public void setPropertyRooms(BigInteger propertyRooms) {
        this.propertyRooms = propertyRooms;
    }

    public String getPropertyLocation() {
        return propertyLocation;
    }

    public void setPropertyLocation(String propertyLocation) {
        this.propertyLocation = propertyLocation;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getOwnerNdi() {
        return ownerNdi;
    }

    public void setOwnerNdi(String ownerNdi) {
        this.ownerNdi = ownerNdi;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }
    
    
}
