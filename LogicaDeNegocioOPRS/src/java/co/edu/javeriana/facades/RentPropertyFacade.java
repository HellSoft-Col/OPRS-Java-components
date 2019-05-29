/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.MailMessage;
import co.edu.javeriana.dtos.RentDTO;
import co.edu.javeriana.dtos.RentPropertyDTO;
import co.edu.javeriana.entities.Customer;
import co.edu.javeriana.entities.Owner;
import co.edu.javeriana.entities.Property;
import co.edu.javeriana.entities.Rent;
import co.edu.javeriana.entities.RentPK;
import co.edu.javeriana.enums.RentStateEnum;
import co.edu.javeriana.integracion.IntegradorColaCorreoLocal;
import co.edu.javeriana.integracion.datos.CustomerFacadeLocal;
import co.edu.javeriana.integracion.datos.OwnerFacadeLocal;
import co.edu.javeriana.integracion.datos.PropertyFacadeLocal;
import co.edu.javeriana.integracion.datos.RentFacadeLocal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author SANTI
 */
@Stateless
public class RentPropertyFacade implements RentPropertyFacadeRemote, RentPropertyFacadeLocal {

    @EJB
    private IntegradorColaCorreoLocal integradorColaCorreo;
    @EJB
    private PropertyFacadeLocal propertyFacade;
    @EJB
    private CustomerFacadeLocal customerFacade;
    @EJB
    private OwnerFacadeLocal ownerFacade;
    @EJB
    private RentFacadeLocal rentFacade;

    @Override
    public boolean AddRent(RentPropertyDTO params) {
        boolean flag = true;
        try {
            Rent new_rent = new Rent(new RentPK(BigInteger.valueOf(999), params.getPropertyId(), params.getPropertyOwnerId(), params.getCustomerId()),new SimpleDateFormat("dd-MM-yyyy").parse( params.getRentalDate()),new SimpleDateFormat("dd-MM-yyyy").parse(params.getRentalTimeStart()), new SimpleDateFormat("dd-MM-yyyy").parse(params.getRentalTimeEnd()), params.getRentProperty(), BigInteger.valueOf(RentStateEnum.getNO_FIRMADO()));
            rentFacade.create(new_rent);
        } catch (Exception e) {
            return false;
        }

        //TODO: Hacer validacion con Institucion financiera
        //TODO: Agregar al topico para lo del ERP
        try {
            MailMessage mailMessageOwner = new MailMessage();
            MailMessage mailMessageCustomer = new MailMessage();

            Owner owner = ownerFacade.findById(params.getPropertyOwnerId().intValue());
            Customer customer = customerFacade.findById(params.getCustomerId().intValue());

            mailMessageOwner.setTo(owner.getEMail());
            mailMessageOwner.setSubject("Notificación OPRS - Renta");

            mailMessageCustomer.setTo(customer.getEMail());
            mailMessageCustomer.setSubject("Notificación OPRS - Renta");

            Property property = propertyFacade.findById(params.getPropertyId().intValue());

            String type;
            if (property.getType() == BigInteger.valueOf(1)) {
                type = "Casa";
            } else {
                type = "Apartamento";
            }

            mailMessageOwner.setBody(
                    "Su " + type
                    + " en " + property.getAddress() + " de " + property.getLocation()
                    + " esta en proceso de renta por " + customer.getName() + " " + customer.getLastName() + " en espera de la firma del contrato. Att: HellSoft");

            mailMessageCustomer.setBody(" El proceso de renta de el/la " + type
                    + " en " + property.getAddress() + " de " + property.getLocation() + " ha sido iniciado y tiene 24 horas para firmarlo desde " + params.getRentalDate().toString() + " si no quiere perder su proceso debe firmar el contrato.");

            integradorColaCorreo.sendJMSMessageToColaCorreo(mailMessageOwner);
            integradorColaCorreo.sendJMSMessageToColaCorreo(mailMessageCustomer);

            return flag;

        } catch (Exception e) {
            return false;
        }

    }

    // Add business logic below. (Right-click in editor and choose
// "Insert Code > Add Business Method")
    @Override
    public boolean SignLease(BigInteger rent_id) {
        try {
            Rent rent = rentFacade.findById(rent_id.intValue());
            rent.setState(BigInteger.valueOf(RentStateEnum.getFIRMADO()));
            rentFacade.edit(rent);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
