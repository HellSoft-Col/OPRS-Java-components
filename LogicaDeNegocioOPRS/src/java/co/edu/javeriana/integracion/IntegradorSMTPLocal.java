/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion;

import co.edu.javeriana.dtos.MailMessage;
import javax.ejb.Local;

/**
 *
 * @author LICHO
 */
@Local
public interface IntegradorSMTPLocal {

    public void sendMail(MailMessage mailMessage);
    
}
