/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.dtos.RentSignDTO;
import co.edu.javeriana.entities.Rent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public List<Rent> findByCustomerAndState(BigDecimal id, BigInteger state) {
        TypedQuery<Rent> consultaCustomer = em.createNamedQuery("Rent.findByCustomerIdAndState", Rent.class);
        consultaCustomer.setParameter("id", id);
        consultaCustomer.setParameter("state", state);
       
        return consultaCustomer.getResultList();
    }

    @Override
    public List<Rent> findByOwnerAndState(BigDecimal id, BigInteger state) {
        TypedQuery<Rent> consultaCustomer = em.createNamedQuery("Rent.findByOwnerIdAndState", Rent.class);
        consultaCustomer.setParameter("id", id);
        consultaCustomer.setParameter("state", state);
       
        return consultaCustomer.getResultList();
    }

    @Override
    public List<RentSignDTO> findByCustomerAndStateDTO(BigDecimal id, BigInteger state) {
        TypedQuery<RentSignDTO> consultaCustomer = em.createNamedQuery("Rent.findByCustomerIdAndStateDTO", RentSignDTO.class);
        consultaCustomer.setParameter("id", id);
        consultaCustomer.setParameter("state", state);
       
        return consultaCustomer.getResultList();
    }

    @Override
    public List<RentSignDTO> findByOwnerAndStateDTO(BigDecimal id, BigInteger state) {
        TypedQuery<RentSignDTO> consultaCustomer = em.createNamedQuery("Rent.findByOwnerIdAndStateDTO", RentSignDTO.class);
        consultaCustomer.setParameter("id", id);
        consultaCustomer.setParameter("state", state);
       
        return consultaCustomer.getResultList();
    }

    @Override
    public Rent findById(int id) {
        TypedQuery<Rent> consultaRent = em.createNamedQuery("Rent.findById",Rent.class);
        consultaRent.setParameter("id", id);
        return consultaRent.getSingleResult();
    }
    
    @Override
    public List<Rent> findByState(BigInteger state){
        TypedQuery<Rent> consultaRent = em.createNamedQuery("Rent.findByState",Rent.class);
        consultaRent.setParameter("state", state);
        return consultaRent.getResultList();
    }
    
    public void edit(Rent rent) {
        em.merge(rent);
    }
    
}
