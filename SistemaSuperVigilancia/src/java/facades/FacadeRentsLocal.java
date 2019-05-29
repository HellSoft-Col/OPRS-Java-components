/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Rent;
import javax.ejb.Local;

/**
 *
 * @author LICHO
 */
@Local
public interface FacadeRentsLocal {

    public void addRent(Rent rent);

    public void saveAllRents();
    
}
