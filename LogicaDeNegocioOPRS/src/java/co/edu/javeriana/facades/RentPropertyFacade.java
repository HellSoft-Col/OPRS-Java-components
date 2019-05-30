/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.MailMessage;
import co.edu.javeriana.dtos.PaymentDTO;
import co.edu.javeriana.dtos.PaymentResponseDTO;
import co.edu.javeriana.dtos.RentDTO;
import co.edu.javeriana.dtos.RentPropertyDTO;
import co.edu.javeriana.dtos.RentarRequest;
import co.edu.javeriana.entities.Customer;
import co.edu.javeriana.entities.Owner;
import co.edu.javeriana.entities.Property;
import co.edu.javeriana.entities.Rent;
import co.edu.javeriana.entities.RentPK;
import co.edu.javeriana.enums.DocumentTypeEnum;
import co.edu.javeriana.enums.RentStateEnum;
import co.edu.javeriana.integracion.IntegradorColaCorreoLocal;
import co.edu.javeriana.integracion.IntegradorTRentasLocal;
import co.edu.javeriana.integracion.datos.CustomerFacadeLocal;
import co.edu.javeriana.integracion.datos.OwnerFacadeLocal;
import co.edu.javeriana.integracion.datos.PropertyFacadeLocal;
import co.edu.javeriana.integracion.datos.RentFacadeLocal;
import co.edu.javeriana.proxies.ProxieInstitucionFinancieraLocal;
import java.math.BigInteger;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author SANTI
 */
@Stateless
public class RentPropertyFacade implements RentPropertyFacadeRemote, RentPropertyFacadeLocal {

    @EJB
    private ProxieInstitucionFinancieraLocal proxieInstitucionFinanciera;
    @EJB
    private IntegradorTRentasLocal integradorTRentas;
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
        Owner owner;
        Customer customer;
        Property property;
        Rent new_rent;
        try {
            owner = ownerFacade.findById(params.getPropertyOwnerId().intValue());
            customer = customerFacade.findById(params.getCustomerId().intValue());
            property = propertyFacade.findById(params.getPropertyId().intValue());
            new_rent = new Rent(new RentPK(BigInteger.valueOf(999), params.getPropertyId(), params.getPropertyOwnerId(), params.getCustomerId()), new SimpleDateFormat("dd-MM-yyyy").parse(params.getRentalDate()), new SimpleDateFormat("dd-MM-yyyy").parse(params.getRentalTimeStart()), new SimpleDateFormat("dd-MM-yyyy").parse(params.getRentalTimeEnd()), params.getRentProperty(), BigInteger.valueOf(RentStateEnum.getNO_FIRMADO()));
            rentFacade.create(new_rent);
        } catch (SQLIntegrityConstraintViolationException e) {
            Logger.getLogger(RentPropertyFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(RentPropertyFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        PaymentDTO payment = new PaymentDTO(DocumentTypeEnum.getDocumentType(params.getType()), params.getNdi(), params.getAccount_password(), params.getRentProperty().intValue());
        PaymentResponseDTO paymentresponse = proxieInstitucionFinanciera.solicitarConfirmacionPago(payment);

        if (paymentresponse.getNumAprobacion() == null || paymentresponse.getAprobacion() == null) {

            MailMessage mailMessageError = new MailMessage();

            mailMessageError.setTo(customer.getEMail());
            mailMessageError.setSubject("Notificación ERROR OPRS - Renta");
         
            mailMessageError.setBody("Buen día Sr./Sra. " + customer.getName() + " " + customer.getLastName() + 
                    " Su pago ha sido declinado, el banco HellBank no puede validar sus datos o no cuenta con suficiente saldo. " +
                    " lo invitamos a resolver los conflictos antes de continuar el proceso de renta. Att: House of dreams.");
            integradorColaCorreo.sendJMSMessageToColaCorreo(mailMessageError);

            return false;
        }

        try {

            RentarRequest rental = new RentarRequest(customer.getNdi(), customer.getName(), customer.getLastName(), property.getLocation(), property.getAddress(), params.getRentalTimeStart(), params.getRentalTimeEnd(), params.getRentProperty().longValue());
            integradorTRentas.sendJMSMessageToTopicoRentas(rental);

            MailMessage mailMessageOwner = new MailMessage();
            MailMessage mailMessageCustomer = new MailMessage();

            mailMessageOwner.setTo(owner.getEMail());
            mailMessageOwner.setSubject("Notificación OPRS - Renta");

            mailMessageCustomer.setTo(customer.getEMail());
            mailMessageCustomer.setSubject("Notificación OPRS - Renta");

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
            Logger.getLogger(RentPropertyFacade.class.getName()).log(Level.SEVERE, null, e);
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

    @Override
    public void verifyState() {
        List<Rent> rents = rentFacade.findByState(BigInteger.valueOf(0));
        Date yesterday = new Date(System.currentTimeMillis() - 3600 * 24 * 1000);
        for (Rent r : rents) {
            if (r.getRentalDate().before(yesterday)) {
                MailMessage message = new MailMessage();
                message.setTo(r.getCustomer().getEMail());
                message.setSubject("Notificación Vencimiento de Contrato");
                message.setBody("El contrato de renta en " + r.getProperty().getAddress() + " localizada en "
                        + r.getProperty().getLocation()+ " ha pasado la fecha límite.");
                integradorColaCorreo.sendJMSMessageToColaCorreo(message);
                r.setState(BigInteger.valueOf(4));
                rentFacade.edit(r);
                System.out.println("Se modifico la renta" + r.getProperty().getAddress());
            }
        }
    }
}
