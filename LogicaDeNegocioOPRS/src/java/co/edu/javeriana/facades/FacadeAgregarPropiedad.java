/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.MailMessage;
import co.edu.javeriana.entities.Owner;
import co.edu.javeriana.entities.Property;
import co.edu.javeriana.integracion.IntegradorColaCorreoLocal;
import co.edu.javeriana.integracion.datos.OwnerFacadeLocal;
import co.edu.javeriana.integracion.datos.PropertyFacade;
import co.edu.javeriana.integracion.datos.PropertyFacadeLocal;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author LICHO
 */
@Stateless
public class FacadeAgregarPropiedad implements FacadeAgregarPropiedadRemote {
    @EJB
    private IntegradorColaCorreoLocal integradorColaCorreo;
    
    @EJB
    private PropertyFacadeLocal propertyFacade;
    
    //Provitional 
    @EJB
    private OwnerFacadeLocal ownerFacade;
    
    @Override
    public boolean addProperty(Property property) {
        
        try {
            boolean result = propertyFacade.addProperty(property);
            MailMessage mailMessage = new MailMessage();
            //TODO: get owner email from session
            //property.getPropertyPK().getOwnerId().intValue()
            Owner owner = ownerFacade.findById(1);
            mailMessage.setTo(owner.getEMail());
            mailMessage.setSubject("Notificación OPRS");
            String type;
            if(property.getType() == BigInteger.valueOf(1))
                type = "Casa";
            else
                type = "Apartamento";
            if(result){
                mailMessage.setBody(
                        "Éxito al añadir la propiedad "+ type
                                +" en "+property.getAddress()+" de "+property.getLocation());
            }
            else{
                mailMessage.setBody(
                        "No se pudo añadir la propiedad "+ type
                                +" en "+property.getAddress()+" de "+property.getLocation()+
                                " por error interno del sistema");
            }
            integradorColaCorreo.sendJMSMessageToColaCorreo(mailMessage);
            return result;
        } catch (Exception ex) {
            Logger.getLogger(FacadeAgregarPropiedad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }  
}
