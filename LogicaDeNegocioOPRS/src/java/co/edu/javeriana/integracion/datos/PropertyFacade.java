/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.dtos.PropertyDTO;
import co.edu.javeriana.entities.Owner;
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
    public List<PropertyDTO> findByRentRange(BigDecimal minimal, BigDecimal maximal) {

        TypedQuery consultaPropiedades = em.createNamedQuery("Property.findByRentRange", PropertyDTO.class);
        consultaPropiedades.setParameter("minumrent", minimal);
        consultaPropiedades.setParameter("maximalrent", maximal);
       
        return consultaPropiedades.getResultList();
    }

    public boolean addProperty(Property property){
        try{
            em.persist(property);
        }
        catch(Exception ex){
            System.out.println(ex);
            return false;
        }
        return true;
    }
    
    public PropertyFacade() {
        super(Property.class);
    }

    @Override
    public List<PropertyDTO> findByCedula(String cedula) {
        TypedQuery<PropertyDTO> consultaOwner = em.createNamedQuery("Property.findByOwnerNDI", PropertyDTO.class);
        consultaOwner.setParameter("ownerNdi", cedula);
        return consultaOwner.getResultList();
    }

    @Override
    public List<PropertyDTO> findByRentRangeAndCedula(String cedula, BigDecimal minimal, BigDecimal maximal) {
        TypedQuery<PropertyDTO> consultaOwner = em.createNamedQuery("Property.findByOwnerNDIAndRange", PropertyDTO.class);
        consultaOwner.setParameter("ownerNdi", cedula);
        consultaOwner.setParameter("minumrent", minimal);
        consultaOwner.setParameter("maximalrent", maximal);
        return consultaOwner.getResultList();
    }

    @Override
    public List<PropertyDTO> findAllDTO() {
        TypedQuery<PropertyDTO> findAll = em.createNamedQuery("Property.findAllDTO", PropertyDTO.class);
        return findAll.getResultList();
    }
    
    @Override
    public Property findById(int id) {
        TypedQuery<Property> consultaProperty = em.createNamedQuery("Property.findById",Property.class);
        consultaProperty.setParameter("id", id);
        return consultaProperty.getSingleResult();
    }   

    @Override
    public Property findById(int id) {
        TypedQuery<Property> consultaProperty = em.createNamedQuery("Property.findById",Property.class);
        consultaProperty.setParameter("id", id);
        return consultaProperty.getSingleResult();
    }

}
