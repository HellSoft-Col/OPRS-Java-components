/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**

 * @author HellSoft
 */


public class RentPropertyDTO implements Serializable {
    
    /* For RENT ID */
    private BigInteger propertyId;
    private BigInteger propertyOwnerId;
    private BigInteger customerId;
    
    /* For rent */
    private String rentalDate;
    private String rentalTimeEnd/* PANTALLA */;
    private String rentalTimeStart/* PANTALLA */;
    private BigDecimal rentProperty; 
    
    /* For payment */
    private String ndi/* PANTALLA */;
    private String account_password /* PANTALLA */;
    private int type; /* PANTALLA */

    public RentPropertyDTO(BigInteger propertyId, BigInteger propertyOwnerId, BigInteger customerId, String rentalDate, String rentalTimeStart, String rentalTimeEnd, BigDecimal rentProperty, String ndi, String account_password, int type) {
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

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getRentalTimeStart() {
        return rentalTimeStart;
    }

    public void setRentalTimeStart(String rentalTimeStart) {
        this.rentalTimeStart = rentalTimeStart;
    }

    public String getRentalTimeEnd() {
        return rentalTimeEnd;
    }

    public void setRentalTimeEnd(String rentalTimeEnd) {
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
