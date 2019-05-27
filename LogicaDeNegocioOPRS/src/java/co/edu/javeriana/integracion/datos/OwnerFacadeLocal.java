/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.entities.Owner;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HellSoft
 */
@Local
public interface OwnerFacadeLocal {

    void create(Owner owner);

    void edit(Owner owner);

    void remove(Owner owner);

    Owner find(Object id);

    List<Owner> findAll();

    List<Owner> findRange(int[] range);

    int count();
    
    Owner findByCedula(String cedula);
}
