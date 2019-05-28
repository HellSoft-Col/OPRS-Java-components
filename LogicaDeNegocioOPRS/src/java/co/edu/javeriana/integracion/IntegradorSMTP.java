/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion;

import co.edu.javeriana.dtos.MailMessage;
import co.edu.javeriana.integracion.datos.OwnerFacadeLocal;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.NamingException;

/**
 *
 * @author LICHO
 */
@Stateless
public class IntegradorSMTP implements IntegradorSMTPLocal {
    
    @Resource(name = "mail/gmailOPRS")
    private Session mailGmailOPRS;
   
    private final String from = "oprs.javeriana@gmail.com";
    
    
    
    @Override
    public void sendMail(MailMessage mailMessage){
        try{
            Message message = new MimeMessage(mailGmailOPRS);
            message.setFrom(new InternetAddress(from));
            Address toAddress = new InternetAddress(mailMessage.getTo());
            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(mailMessage.getSubject());
            message.setContent(mailMessage.getBody(), "text/plain");
            Transport.send(message);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
}
