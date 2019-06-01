/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.entities.RentDeal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HellSoft
 */
@Stateless
public class RentDealFacade extends AbstractFacade<RentDeal> implements RentDealFacadeLocal {

    @PersistenceContext(unitName = "LogicaERPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RentDealFacade() {
        super(RentDeal.class);
    }

    public boolean addContrato(RentDeal contrato) {
        try {
            em.persist(contrato);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
