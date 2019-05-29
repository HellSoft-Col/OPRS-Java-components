/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.RentPropertyDTO;
import java.math.BigInteger;
import javax.ejb.Remote;

/**
 *
 * @author SANTI
 */
@Remote
public interface RentPropertyFacadeRemote {
    public boolean AddRent(RentPropertyDTO params);
    
    public boolean SignLease(BigInteger rent_id);
}
