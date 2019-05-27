/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.entities.Rent;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SANTI
 */
@Local
public interface RentFacadeLocal {

    void create(Rent rent);

    void edit(Rent rent);

    void remove(Rent rent);

    Rent find(Object id);

    List<Rent> findAll();

    List<Rent> findRange(int[] range);

    int count();
    
}
