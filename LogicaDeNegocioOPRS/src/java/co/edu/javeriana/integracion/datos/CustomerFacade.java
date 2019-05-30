/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.dtos.LoginDTO;
import co.edu.javeriana.dtos.PropertyDTO;
import co.edu.javeriana.entities.Customer;
import co.edu.javeriana.entities.Owner;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author HellSoft
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {
    @PersistenceContext(unitName = "LogicaDeNegocioOPRSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    

    public CustomerFacade() {
        super(Customer.class);
    }

    @Override
    public LoginDTO findByLogin(String username, String password) {
        LoginDTO login = new LoginDTO();
        TypedQuery<LoginDTO> iniciarSesion = em.createNamedQuery("Customer.findByLogin", LoginDTO.class);
        iniciarSesion.setParameter("username", username);
        iniciarSesion.setParameter("password", password);
        try{
           login = iniciarSesion.getSingleResult();
        }catch(NoResultException e){
           login = new LoginDTO();
        }
        
        return login; 
        
    }

    @Override
    public Customer findById(int id) {
        TypedQuery<Customer> consultaCustomer = em.createNamedQuery("Customer.findById",Customer.class);
        consultaCustomer.setParameter("id", id);
        return consultaCustomer.getSingleResult();
    }
    
}
