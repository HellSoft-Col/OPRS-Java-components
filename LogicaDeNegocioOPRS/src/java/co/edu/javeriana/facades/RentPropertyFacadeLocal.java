/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.RentPropertyDTO;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Local;

/**
 *
 * @author SANTI
 */
@Local
public interface RentPropertyFacadeLocal {
    public boolean AddRent(RentPropertyDTO params);
    
    public boolean SignLease(BigInteger rent_id);
}
