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
    private Date rentalDate;
    private Date rentalTimeStart;
    private Date rentalTimeEnd;
    private double rentProperty;
    private String state;
    private String nameCustomer;
    private String lastNameCustomer;
    private String ndiCustomer;
    private String eMailCostumer;
    private String typeProperty;
    private String addressProperty;
    private BigInteger roomsNumberProperty;
    private String locationProperty;
    private String nameOwner;
    private String lastNameOwner;
    private String ndiOwner;
    private String eMailOwner;

    public RentDTO() {
    }

    public RentDTO(Date rentalDate, Date rentalTimeStart, Date rentalTimeEnd, double rentProperty, String state, String nameCustomer, String lastNameCustomer, String ndiCustomer, String eMailCostumer, String typeProperty, String addressProperty, BigInteger roomsNumberProperty, String locationProperty, String nameOwner, String lastNameOwner, String ndiOwner, String eMailOwner) {
        this.rentalDate = rentalDate;
        this.rentalTimeStart = rentalTimeStart;
        this.rentalTimeEnd = rentalTimeEnd;
        this.rentProperty = rentProperty;
        this.state = state;
        this.nameCustomer = nameCustomer;
        this.lastNameCustomer = lastNameCustomer;
        this.ndiCustomer = ndiCustomer;
        this.eMailCostumer = eMailCostumer;
        this.typeProperty = typeProperty;
        this.addressProperty = addressProperty;
        this.roomsNumberProperty = roomsNumberProperty;
        this.locationProperty = locationProperty;
        this.nameOwner = nameOwner;
        this.lastNameOwner = lastNameOwner;
        this.ndiOwner = ndiOwner;
        this.eMailOwner = eMailOwner;
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

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getLastNameCustomer() {
        return lastNameCustomer;
    }

    public void setLastNameCustomer(String lastNameCustomer) {
        this.lastNameCustomer = lastNameCustomer;
    }

    public String getNdiCustomer() {
        return ndiCustomer;
    }

    public void setNdiCustomer(String ndiCustomer) {
        this.ndiCustomer = ndiCustomer;
    }

    public String geteMailCostumer() {
        return eMailCostumer;
    }

    public void seteMailCostumer(String eMailCostumer) {
        this.eMailCostumer = eMailCostumer;
    }

    public String getTypeProperty() {
        return typeProperty;
    }

    public void setTypeProperty(String typeProperty) {
        this.typeProperty = typeProperty;
    }

    public String getAddressProperty() {
        return addressProperty;
    }

    public void setAddressProperty(String addressProperty) {
        this.addressProperty = addressProperty;
    }

    public BigInteger getRoomsNumberProperty() {
        return roomsNumberProperty;
    }

    public void setRoomsNumberProperty(BigInteger roomsNumberProperty) {
        this.roomsNumberProperty = roomsNumberProperty;
    }

    public String getLocationProperty() {
        return locationProperty;
    }

    public void setLocationProperty(String locationProperty) {
        this.locationProperty = locationProperty;
    }

    public String getNameOwner() {
        return nameOwner;
    }

    public void setNameOwner(String nameOwner) {
        this.nameOwner = nameOwner;
    }

    public String getLastNameOwner() {
        return lastNameOwner;
    }

    public void setLastNameOwner(String lastNameOwner) {
        this.lastNameOwner = lastNameOwner;
    }

    public String getNdiOwner() {
        return ndiOwner;
    }

    public void setNdiOwner(String ndiOwner) {
        this.ndiOwner = ndiOwner;
    }

    public String geteMailOwner() {
        return eMailOwner;
    }

    public void seteMailOwner(String eMailOwner) {
        this.eMailOwner = eMailOwner;
    }
    
}
