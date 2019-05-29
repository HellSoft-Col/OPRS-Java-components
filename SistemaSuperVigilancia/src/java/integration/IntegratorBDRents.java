/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import entities.Renta;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LICHO
 */
@Stateless
@LocalBean
public class IntegratorBDRents {
    @PersistenceContext(unitName = "SistemaSuperVigilanciaPU")
    private EntityManager em;

    public void persist(Renta object) {
        em.persist(object);
    }    

    public BigDecimal getSequenceVal() {
        Query q = em.createNativeQuery("SELECT SEQUENCE_RENTS.nextval from DUAL");
        BigDecimal result=(BigDecimal)q.getSingleResult();   
        return result;
    }
    
}
