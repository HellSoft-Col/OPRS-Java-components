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

/**
 *
 * @author SANTI
 */
public class RentPropertyDTO implements Serializable {
    
    /* For RENT ID */
    private BigInteger propertyId;
    private BigInteger propertyOwnerId;
    private BigInteger customerId;
    
    /* For rent */
    private Date rentalDate;
    private Date rentalTimeStart;
    private Date rentalTimeEnd;
    private BigDecimal rentProperty; 
    
    /* For payment */
    private String ndi;
    private String account_password;
    private int type;

    public RentPropertyDTO(BigInteger propertyId, BigInteger propertyOwnerId, BigInteger customerId, Date rentalDate, Date rentalTimeStart, Date rentalTimeEnd, BigDecimal rentProperty, String ndi, String account_password, int type) {
        this.propertyId = propertyId;
        this.propertyOwnerId = propertyOwnerId;
        this.customerId = customerId;
        this.rentalDate = rentalDate;
        this.rentalTimeStart = rentalTimeStart;
        this.rentalTimeEnd = rentalTimeEnd;
        this.rentProperty = rentProperty;
        this.ndi = ndi;
        this.account_password = account_password;
        this.type = type;
    }
    
    
    
    public BigInteger getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(BigInteger propertyId) {
        this.propertyId = propertyId;
    }

    public BigInteger getPropertyOwnerId() {
        return propertyOwnerId;
    }

    public void setPropertyOwnerId(BigInteger propertyOwnerId) {
        this.propertyOwnerId = propertyOwnerId;
    }

    public BigInteger getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
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

    public String getNdi() {
        return ndi;
    }

    public void setNdi(String ndi) {
        this.ndi = ndi;
    }

    public String getAccount_password() {
        return account_password;
    }

    public void setAccount_password(String account_password) {
        this.account_password = account_password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
}
