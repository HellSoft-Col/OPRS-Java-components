/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.RentarRequest;
import co.edu.javeriana.integracion.IntegradorTRentasLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author sistemas
 */
@Stateless
public class FRentarPropiedad implements FRentarPropiedadRemote, FRentarPropiedadLocal {
    @EJB
    private IntegradorTRentasLocal integradorTRentas;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void enviarContrato(RentarRequest contrato) {
        integradorTRentas.sendJMSMessageToTopicoRentas(contrato);
    }
    
}
