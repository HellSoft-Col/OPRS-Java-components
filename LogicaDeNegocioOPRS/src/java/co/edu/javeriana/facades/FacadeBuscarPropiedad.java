/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.PropertyDTO;
import co.edu.javeriana.dtos.PropertyQueryDTO;
import co.edu.javeriana.entities.Property;
import co.edu.javeriana.integracion.datos.PropertyFacade;
import co.edu.javeriana.integracion.datos.PropertyFacadeLocal;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HellSoft
 */
@Stateless
public class FacadeBuscarPropiedad implements FacadeBuscarPropiedadRemote, FacadeBuscarPropiedadLocal {

    @EJB
    private PropertyFacadeLocal propertyFacade;

    @Override
    public List<PropertyDTO> searchProperty(PropertyQueryDTO params) {

        List<PropertyDTO> result = new ArrayList<PropertyDTO>();
        if (params.getCedulaProp() != null && (params.getMaximalRent() != -1 && params.getMinimalRent() != -1)) {
            BigDecimal min = new BigDecimal(Float.toString(params.getMinimalRent()));
            BigDecimal max = new BigDecimal(Float.toString(params.getMaximalRent()));
            result = propertyFacade.findByRentRangeAndCedula(params.getCedulaProp(), min, max);
        } else if (params.getCedulaProp() == null && (params.getMaximalRent() != -1 && params.getMinimalRent() != -1)) {

            BigDecimal min = new BigDecimal(Float.toString(params.getMinimalRent()));
            BigDecimal max = new BigDecimal(Float.toString(params.getMaximalRent()));
            result = propertyFacade.findByRentRange(min, max);

        } else if (params.getCedulaProp() != null && (params.getMaximalRent() == -1 && params.getMinimalRent() == -1)) {
            result = propertyFacade.findByCedula(params.getCedulaProp());
        }
        
        return result;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
