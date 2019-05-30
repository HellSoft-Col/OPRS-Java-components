/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.mensajes;

import co.edu.javeriana.dtos.MailMessage;
import co.edu.javeriana.integracion.IntegradorSMTPLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author LICHO
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/colaCorreo"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ListenerColaCorreo implements MessageListener {
    @EJB
    private IntegradorSMTPLocal integradorSMTP;
    
    public ListenerColaCorreo() {
    }
    
    @Override
    public void onMessage(Message message) {
      MailMessage objMsg;
        try {
            objMsg = (MailMessage) message.getBody(MailMessage.class);
            integradorSMTP.sendMail(objMsg);
        } catch (JMSException ex) {
            Logger.getLogger(ListenerColaCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
}
