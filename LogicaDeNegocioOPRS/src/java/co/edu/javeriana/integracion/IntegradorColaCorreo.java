/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion;

import co.edu.javeriana.dtos.MailMessage;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.Queue;

/**
 *
 * @author LICHO
 */
@Stateless
public class IntegradorColaCorreo implements IntegradorColaCorreoLocal {
    @Resource(mappedName = "jms/colaCorreo")
    private Queue colaCorreo;
    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    public void sendJMSMessageToColaCorreo(MailMessage message) {
        context.createProducer().send(colaCorreo, message);
                //end(colaCorreo, message);
    }
}
