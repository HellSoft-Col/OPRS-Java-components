/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.entities.Property;
import co.edu.javeriana.integracion.datos.PropertyFacade;
import co.edu.javeriana.integracion.datos.PropertyFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author LICHO
 */
@Stateless
public class FacadeAgregarPropiedad implements FacadeAgregarPropiedadRemote {
    
    @EJB
    private PropertyFacadeLocal propertyFacade;

    @Override
    public boolean addProperty(Property property) {
        return propertyFacade.addProperty(property);
    }  
}
