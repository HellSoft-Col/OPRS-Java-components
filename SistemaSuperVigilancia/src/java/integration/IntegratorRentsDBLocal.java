/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import entities.Rent;
import java.math.BigInteger;
import javax.ejb.Local;

/**
 *
 * @author LICHO
 */
@Local
public interface IntegratorRentsDBLocal {

    public void addRent(Rent rent);

    public BigInteger getSequenceVal();
    
}
