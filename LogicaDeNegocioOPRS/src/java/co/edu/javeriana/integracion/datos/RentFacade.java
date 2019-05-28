/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.dtos.PropertyDTO;
import co.edu.javeriana.entities.Rent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    public List<PropertyDTO> findRentPropertiesByNdi(String ndi) {
        Query rentProperties = em.createNamedQuery("Rent.findRentPropertiesByNdi");
        rentProperties.setParameter("ndi", ndi);
        List<Object[]> result_list = rentProperties.getResultList();
        List<PropertyDTO> result_set = new ArrayList<PropertyDTO>();
        for (Object[] obj : result_list) {
            PropertyDTO p = new PropertyDTO(obj[0].toString(), obj[1].toString(), new BigDecimal(obj[2].toString()), new BigInteger(obj[3].toString()), new BigInteger(obj[4].toString()));
            result_set.add(p);
        }
        return result_set;
    }
    
}
