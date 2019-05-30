/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.mensajes;

import co.edu.javeriana.dtos.RentarRequest;
import co.edu.javeriana.facades.FacadeERPLocal;
import java.util.Enumeration;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author pabloarizaluna
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/TopicoRentas"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/TopicoRentas"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/TopicoRentas"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "System = 'All'"),})
public class ListenerERP implements MessageListener {

    @EJB
    private FacadeERPLocal facadeERP;

    public ListenerERP() {
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof MapMessage) {
            MapMessage mm = (MapMessage) message;
            String request = "";
            RentarRequest renta = new RentarRequest();

            try {
                Enumeration<String> mapNames = mm.getMapNames();
                while (mapNames.hasMoreElements()) {
                    // Read all of the map elements as strings
                    String name = mapNames.nextElement();
                    request += name + ": " + mm.getString(name) + " | ";
                }
                renta.setNdi(mm.getString("NdI"));
                renta.setFirst_name(mm.getString("FirstName"));
                renta.setLast_name(mm.getString("LastName"));
                renta.setLocation_address(mm.getString("LocationAddress"));
                renta.setProperty_address(mm.getString("PropertyAddress"));
                renta.setRental_time_start(mm.getString("RentalTimeStart"));
                renta.setRental_time_end(mm.getString("RentalTimeEnd"));
                renta.setAmount(mm.getLong("Amount"));
                System.out.println(this.getClass().getName() + ": Received a request for " + message.getStringProperty("System"));
                System.out.println(request);
                //facadeERP.agregarContrato(renta);
            } catch (JMSException ex) {
                System.out.println("Failed to get request message");
            }
        }
    }

}
