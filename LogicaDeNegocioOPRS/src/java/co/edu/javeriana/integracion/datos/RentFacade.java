/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.dtos.PropertyDTO;
import co.edu.javeriana.dtos.RentsCustomerDTO;
import co.edu.javeriana.entities.Rent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
public class RentFacade extends AbstractFacade<Rent> implements RentFacadeLocal {
    @PersistenceContext(unitName = "LogicaDeNegocioOPRSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RentFacade() {
        super(Rent.class);
    }

    @Override
    public List<RentsCustomerDTO> findRentPropertiesByNdi() {
        TypedQuery rentProperties = em.createNamedQuery("Rent.findRentPropertiesByNdi", RentsCustomerDTO.class);
        return rentProperties.getResultList();
    }
    
}
