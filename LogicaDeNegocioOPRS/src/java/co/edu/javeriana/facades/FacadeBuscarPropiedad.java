/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.PropertyQueryDTO;
import co.edu.javeriana.entities.Property;
import co.edu.javeriana.integracion.datos.PropertyFacade;
import co.edu.javeriana.integracion.datos.PropertyFacadeLocal;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author SANTI
 */
@Stateless
public class FacadeBuscarPropiedad implements FacadeBuscarPropiedadRemote, FacadeBuscarPropiedadLocal {
    @EJB
    private PropertyFacadeLocal propertyFacade;
    
    @Override
    public List<Property> searchProperty(PropertyQueryDTO params) {
        BigDecimal min = new BigDecimal(Float.toString(params.getMinimalRent()));
        BigDecimal max = new BigDecimal(Float.toString(params.getMaximalRent()));
        return propertyFacade.findByRentRange(min, max);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
