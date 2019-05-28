/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.PropertyDTO;
import co.edu.javeriana.integracion.datos.RentFacadeLocal;
import java.util.List;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author anfec
 */
@Stateless
public class FacadeListarPropiedades implements FacadeListarPropiedadesLocal{

    @EJB
    private RentFacadeLocal rentFacade;
    
    @Asynchronous
    @Override
    public List<PropertyDTO> ListRentPropertiesByUser(String cedula){
        List<PropertyDTO> rentProperties = rentFacade.findRentPropertiesByNdi(cedula);
        return rentProperties;
    }
}
