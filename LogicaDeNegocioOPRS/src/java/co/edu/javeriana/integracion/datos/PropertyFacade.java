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

        Query consultaPropiedades = em.createNamedQuery("Property.findByRentRange");
        consultaPropiedades.setParameter("minumrent", minimal);
        consultaPropiedades.setParameter("maximalrent", maximal);
        List<Object[]> result_list = consultaPropiedades.getResultList();
        List<PropertyDTO> result_set = new ArrayList<PropertyDTO>();
        for (Object[] obj : result_list) {
            PropertyDTO p = new PropertyDTO(obj[0].toString(), obj[1].toString(), new BigDecimal(obj[2].toString()), new BigInteger(obj[3].toString()), new BigInteger(obj[4].toString()));
            result_set.add(p);
        }

        return result_set;

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

        TypedQuery<PropertyDTO> consultaOwner = em.createNamedQuery("Property.findByOwnerNDI", PropertyDTO.class);
        consultaOwner.setParameter("ownerNdi", cedula);
        List<PropertyDTO> result_p = consultaOwner.getResultList();

        List<PropertyDTO> result = new ArrayList<PropertyDTO>();

        for (PropertyDTO p : result_p) {
            if (p.getRent().compareTo(minimal) >= 0 && p.getRent().compareTo(maximal) <= 0) {
                result.add(p);
            }
        }

        return result;
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

}
