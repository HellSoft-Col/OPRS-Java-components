/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.entities.Owner;
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
public class OwnerFacade extends AbstractFacade<Owner> implements OwnerFacadeLocal {
    @PersistenceContext(unitName = "LogicaDeNegocioOPRSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OwnerFacade() {
        super(Owner.class);
    }

    @Override
    public Owner findByCedula(String cedula) {
        TypedQuery<Owner> consultaOwner = em.createNamedQuery("Owner.findByNdi",Owner.class);
        consultaOwner.setParameter("ndi", cedula);
        return consultaOwner.getSingleResult();
    }
    
}
