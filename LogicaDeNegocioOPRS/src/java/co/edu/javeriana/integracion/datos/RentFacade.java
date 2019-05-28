/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.dtos.RentDTO;
import co.edu.javeriana.entities.Customer;
import co.edu.javeriana.entities.Owner;
import co.edu.javeriana.entities.Property;
import co.edu.javeriana.entities.Rent;
import co.edu.javeriana.enums.PropertyTypeEnum;
import co.edu.javeriana.enums.RentStateEnum;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
    public List<RentDTO> findRentTransactions(){
        List<RentDTO> resultDTO = new ArrayList<>();
        Query consultaPropiedades = em.createNamedQuery("Rent.findAll");
        List<Rent> result_list = consultaPropiedades.getResultList();
        for (Rent rent : result_list) {
            RentDTO r = new RentDTO();
            r.setRentalDate(rent.getRentalDate());
            r.setRentalTimeStart(rent.getRentalTimeStart());
            r.setRentalTimeEnd(rent.getRentalTimeEnd());
            r.setRentProperty(rent.getRentProperty());
            r.setState(RentStateEnum.getState(rent.getState().intValue()));
            //Customer data
            Customer c = rent.getCustomer();
            r.setNameCustomer(c.getName());
            r.setLastNameCustomer(c.getLastName());
            r.setNdiCustomer(c.getNdi());
            r.seteMailCustomer(c.getEMail());
            //Property data
            Property p = rent.getProperty();
            r.setTypeProperty(PropertyTypeEnum.getStringName(p.getType().intValue()));
            r.setAddressProperty(p.getAddress());
            r.setRoomsNumberProperty(p.getRoomsNumber());
            r.setLocationProperty(p.getLocation());
            //Owner data
            Owner o = p.getOwner();
            r.setNameOwner(o.getName());
            r.setLastNameOwner(o.getLastName());
            r.setNdiOwner(o.getNdi());
            r.seteMailOwner(o.getEMail());    
            resultDTO.add(r);
        }
        return resultDTO;
    }
    
}
