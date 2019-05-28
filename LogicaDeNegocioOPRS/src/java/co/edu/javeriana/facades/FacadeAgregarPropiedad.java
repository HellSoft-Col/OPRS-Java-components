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
        boolean result = propertyFacade.addProperty(property);
        MailMessage mailMessage = new MailMessage();
        //TODO: get owner email from session
        //property.getPropertyPK().getOwnerId().intValue()
        Owner owner = ownerFacade.findById(1);
        mailMessage.setTo(owner.getEMail());
        mailMessage.setSubject("Notificación OPRS");
        if(result){
            mailMessage.setBody(
                    "Éxito al añadir la propiedad "+ property.getType()
                            +" en "+property.getAddress()+" de "+property.getLocation());
        }
        else{
            mailMessage.setBody(
                    "No se pudo añadir la propiedad "+ property.getType()
                            +" en "+property.getAddress()+" de "+property.getLocation());
        }
        integradorColaCorreo.sendJMSMessageToColaCorreo(mailMessage);
        return result;
    }  
}
