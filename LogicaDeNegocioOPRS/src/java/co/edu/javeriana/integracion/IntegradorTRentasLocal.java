/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion;

import co.edu.javeriana.dtos.RentarRequest;
import javax.ejb.Local;

/**
 *
 * @author sistemas
 */
@Local
public interface IntegradorTRentasLocal {

    public void sendJMSMessageToTopicoRentas(RentarRequest contrato);
    
}
