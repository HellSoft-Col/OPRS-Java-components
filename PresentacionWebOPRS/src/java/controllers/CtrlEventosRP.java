/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import co.edu.javeriana.dtos.RentarRequest;
import co.edu.javeriana.facades.FRentarPropiedadRemote;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author sistemas
 */
@ManagedBean
@SessionScoped
public class CtrlEventosRP {
    @EJB
    private FRentarPropiedadRemote fRentarPropiedad;
    
    private RentarRequest contrato;

    /**
     * Creates a new instance of CtrlEventosRP
     */
    public CtrlEventosRP() {
        contrato = new RentarRequest();
    }

    public RentarRequest getContrato() {
        return contrato;
    }

    public void setContrato(RentarRequest contrato) {
        this.contrato = contrato;
    }
    
    public void enviarContrato() {
        fRentarPropiedad.enviarContrato(contrato);
    }
    
    
}
