/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.entities.Property;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HellSoft
 */
@Local
public interface PropertyFacadeLocal {

    void create(Property property);

    void edit(Property property);

    void remove(Property property);

    Property find(Object id);

    List<Property> findAll();

    List<Property> findRange(int[] range);

    int count();
    
    public List<Property> findByRentRange(BigDecimal minimal, BigDecimal maximal);
    
    public List<Property> findByCedula(String cedula);
   
    public List<Property> findByRentRangeAndCedula(String cedula, BigDecimal minimal, BigDecimal maximal);
    
    public boolean addProperty(Property property);
}
