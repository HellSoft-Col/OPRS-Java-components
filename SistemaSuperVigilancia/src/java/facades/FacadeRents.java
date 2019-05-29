/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entities.Rent;
import entities.RentDTO;
import integration.IntegratorRentsDBLocal;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import proxies.ProxyRents;

/**
 *
 * @author LICHO
 */
@Stateless
public class FacadeRents implements FacadeRentsLocal {
    @EJB
    private IntegratorRentsDBLocal integratorRentsDB;
    
    @Override
    public void addRent(Rent rent){
        integratorRentsDB.addRent(rent);
    }
    
    @Override
    public void saveAllRents(){
        BigInteger seq = integratorRentsDB.getSequenceVal();
        Gson gson = new Gson();
        Type listTypeProperty = new TypeToken<ArrayList<RentDTO>>() {}.getType();
        ProxyRents proxyRents = new ProxyRents();
        String response = proxyRents.getRentsJson(String.class);
        List<RentDTO> results = gson.fromJson(response, listTypeProperty);
        for(RentDTO r : results){
            Rent newRent = new Rent(r.getRentalDate(), r.getRentalTimeStart(), r.getRentalTimeEnd(), 
                    r.getRentProperty(), r.getState(), r.getCostumerName(), 
                    r.getCostumerLastName(), r.getCustomerNdi(), r.getCustomerEmail(), 
                    r.getPropertyType(), r.getPropertyAddress(), r.getPropertyRooms(), 
                    r.getPropertyLocation(), r.getOwnerName(), r.getOwnerLastName(), 
                    r.getOwnerNdi(), r.getOwnerEmail(), seq);
            this.addRent(newRent);
        }
    }
}
