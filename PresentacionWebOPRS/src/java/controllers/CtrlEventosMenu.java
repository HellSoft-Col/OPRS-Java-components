/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import co.edu.javeriana.dtos.LoginDTO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author HellSoft
 */
@Named(value = "ctrlEventosMenu")
@ManagedBean
@RequestScoped
public class CtrlEventosMenu {

    /**
     * Creates a new instance of CtrlEventosMenu
     */
    public CtrlEventosMenu() {
    }
    public String rentarP(){        
        return "PantallaWebRP";
    }
    public String buscarP(){
        return "PantallaWebBP";
    }
    
}
