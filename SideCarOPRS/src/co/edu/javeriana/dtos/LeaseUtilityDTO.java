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
 *
 * @author SANTI
 */
public class LeaseUtilityDTO implements Serializable{
    private BigDecimal user_id;
    private BigInteger lease_id;

    public LeaseUtilityDTO(){
        this.user_id = BigDecimal.valueOf(-1);
        this.lease_id = BigInteger.valueOf(-1);
    }
    
    public BigDecimal getUser_id() {
        return user_id;
    }

    public void setUser_id(BigDecimal user_id) {
        this.user_id = user_id;
    }

    public BigInteger getLease_id() {
        return lease_id;
    }

    public void setLease_id(BigInteger lease_id) {
        this.lease_id = lease_id;
    }
    
    
    
}
