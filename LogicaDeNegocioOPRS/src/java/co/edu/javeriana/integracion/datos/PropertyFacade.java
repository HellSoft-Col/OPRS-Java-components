/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.entities.Property;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author HellSoft
 */
@Stateless
public class PropertyFacade extends AbstractFacade<Property> implements PropertyFacadeLocal {
    @EJB
    private OwnerFacadeLocal ownerFacade;
    @PersistenceContext(unitName = "LogicaDeNegocioOPRSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public List<Property> findByRentRange(BigDecimal minimal, BigDecimal maximal) {
        
        Query consultaPropiedades = em.createNamedQuery("Property.findByRentRange");
        consultaPropiedades.setParameter("minumrent", minimal);
        consultaPropiedades.setParameter("maximalrent", maximal);
        List<Object[]> result_list = consultaPropiedades.getResultList();
        List<Property> result_set = new ArrayList<Property>();
        for(Object[] obj: result_list){
            Property p = new Property();
            p.setAddress(obj[0].toString());
            p.setLocation(obj[1].toString());
            p.setRent(new BigDecimal(obj[2].toString()));
            p.setRoomsNumber(new BigInteger(obj[3].toString()));
            p.setType(new BigInteger(obj[4].toString()));
            result_set.add(p);
        }
        
        return result_set;
    
    }

    public boolean addProperty(Property property){
        try{
            em.persist(property);
        }
        catch(Exception ex){
            return false;
        }
        return true;
    }
    
    public PropertyFacade() {
        super(Property.class);
    }

    @Override
    public List<Property> findByCedula(String cedula) {
        return new ArrayList<Property>(ownerFacade.findByCedula(cedula).getPropertyCollection());    
    }

    @Override
    public List<Property> findByRentRangeAndCedula(String cedula, BigDecimal minimal, BigDecimal maximal) {
        List<Property> properties = new ArrayList<Property>(ownerFacade.findByCedula(cedula).getPropertyCollection());
        List<Property> result = new ArrayList<Property>();
        
        for (Property p: properties){
            if( p.getRent().compareTo(minimal) >= 0 && p.getRent().compareTo(maximal) <= 0){
                result.add(p);
            }
        }
        
        return result;
    }
    
}
