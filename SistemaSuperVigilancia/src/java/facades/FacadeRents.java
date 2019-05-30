/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entities.RentDTO;
import entities.Renta;
import integration.IntegratorBDRents;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import proxies.ProxyRents;

/**
 *
 * @author LICHO
 */
@Stateless
@LocalBean
public class FacadeRents {

    @EJB
    private IntegratorBDRents integratorBDRents;
   
    public void saveAllRents(){
        BigDecimal seq = integratorBDRents.getSequenceVal();
        Gson gson = new Gson();
        ProxyRents proxyRents = new ProxyRents();
        String response = proxyRents.getRentsJson(String.class);
        List<RentDTO> results = gson.fromJson(response, new TypeToken<List<RentDTO>>(){}.getType());
        for(RentDTO r : results){
            Renta newRent = new Renta(BigDecimal.ONE,r.getRentalDate(), r.getRentalTimeStart(), r.getRentalTimeEnd(), 
                    r.getRentProperty(), r.getState(), r.getNameCustomer(), 
                    r.getLastNameCustomer(), r.getNdiCustomer(), r.geteMailOwner(), 
                    r.getTypeProperty(), r.getAddressProperty(), r.getRoomsNumberProperty(), 
                    r.getLocationProperty(), r.getNameOwner(), r.getLastNameOwner(), 
                    r.getNdiOwner(), r.geteMailOwner(), seq.toBigInteger());
            System.out.println(seq); 
            integratorBDRents.persist(newRent);
        }
    }
}
