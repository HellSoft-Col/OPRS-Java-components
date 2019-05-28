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
import javax.jms.Topic;

/**
 *
 * @author sistemas
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
        //context.createProducer().send(topicoRentas, messageData);
    }
}
