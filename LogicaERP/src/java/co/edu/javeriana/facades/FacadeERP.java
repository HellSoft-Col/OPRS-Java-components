/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.RentarRequest;
import co.edu.javeriana.entities.RentDeal;
import co.edu.javeriana.integracion.datos.RentDealFacadeLocal;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author pabloarizaluna
 */
@Stateless
public class FacadeERP implements FacadeERPLocal {

    @EJB
    private RentDealFacadeLocal rentDealFacade;

    @Override
    public void agregarContrato(RentarRequest contrato) {
        RentDeal rent = new RentDeal();
        try {
            rent.setId(BigDecimal.valueOf(rentDealFacade.count() + 1));
            rent.setNdi(contrato.getNdi());
            rent.setName(contrato.getFirst_name());
            rent.setLastName(contrato.getLast_name());
            rent.setLocationAddress(contrato.getLocation_address());
            rent.setPropertyAddress(contrato.getProperty_address());
            Date timeStart = new SimpleDateFormat("dd/MM/yyyy").parse(contrato.getRental_time_start());
            rent.setRentalTimeStart(timeStart);
            Date timeEnd = new SimpleDateFormat("dd/MM/yyyy").parse(contrato.getRental_time_end());
            rent.setRentalTimeEnd(timeEnd);
            rent.setAmount(contrato.getAmount());
            System.out.println("Facade ERP: ");
            System.out.println(rent.getLocationAddress());
            rentDealFacade.addContrato(rent);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
