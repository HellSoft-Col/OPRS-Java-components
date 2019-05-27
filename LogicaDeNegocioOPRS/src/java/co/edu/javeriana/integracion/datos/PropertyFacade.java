/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.entities.Property;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author SANTI
 */
@Stateless
public class PropertyFacade extends AbstractFacade<Property> implements PropertyFacadeLocal {
    @PersistenceContext(unitName = "LogicaDeNegocioOPRSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public List<Property> findByRentRange(BigDecimal minimal, BigDecimal maximal) {
        TypedQuery<Property> consultaPropiedades = em.createNamedQuery("Property.findByRentRange", Property.class);
        consultaPropiedades.setParameter("minumrent", minimal);
        consultaPropiedades.setParameter("maximalrent", maximal);
        return consultaPropiedades.getResultList();
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
    
}
