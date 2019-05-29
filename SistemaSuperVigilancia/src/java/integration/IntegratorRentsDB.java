/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import entities.Rent;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LICHO
 */
@Stateless
public class IntegratorRentsDB implements IntegratorRentsDBLocal {
    @PersistenceContext(unitName = "SistemaSuperVigilanciaPU")
    private EntityManager em;

    @Override
    public void addRent(Rent rent){
        try{
            em.persist(rent);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    @Override
    public BigInteger getSequenceVal(){
        Query q = em.createNativeQuery("SELECT SEQUENCE_RENTS.NEXTVAL FROM DUAL");
        return (java.math.BigInteger)q.getSingleResult();
    }
    
}
