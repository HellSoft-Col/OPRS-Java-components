/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion;

import co.edu.javeriana.dtos.RentarRequest;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Topic;

/**
 *
 * @author HellSoft
 */
@Stateless
public class IntegradorTRentas implements IntegradorTRentasRemote, IntegradorTRentasLocal {
    @Resource(mappedName = "jms/TopicoRentas")
    private Topic topicoRentas;
    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void sendJMSMessageToTopicoRentas(RentarRequest messageData) {
        System.out.println("Llego al integrador con: ");
        System.out.println(messageData);
        try {
            JMSProducer messageProducer = context.createProducer();
            MapMessage mm = context.createMapMessage();
            mm.setString("NdI", messageData.getNdi());
            mm.setString("FirstName", messageData.getFirst_name());
            mm.setString("LastName", messageData.getLast_name());
            mm.setString("LocationAddress", messageData.getLocation_address());
            mm.setString("PropertyAddress", messageData.getProperty_address());
            mm.setString("RentalTimeStart", messageData.getRental_time_start());
            mm.setString("RentalTimeEnd", messageData.getRental_time_end());
            mm.setLong("Amount", messageData.getAmount());
            mm.setStringProperty("System", "All");
            messageProducer.send(topicoRentas, mm);
        } catch (JMSException e) {
            System.err.println(e);
        }
        System.out.println("Envio el mensaje");
        //context.createProducer().send(topicoRentas, messageData);
    }
}
