/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import co.edu.javeriana.dtos.LoginDTO;
import java.io.Serializable;
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
public class CtrlEventosMenu implements Serializable{

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
    public String rentSign(){
        return "PantallaWebRentSign";
    }
    public String logOut(){
        return "index";
    }
    public String showCustomerName(){
       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
       Map sessionMap = externalContext.getSessionMap();
       LoginDTO currentUser = (LoginDTO) sessionMap.get("user"); 
       String nameCustom = currentUser.getName();
       String lastCustom = currentUser.getLastName();
       String completeName = "Bienvenido: " + " "+nameCustom + " " + lastCustom;
       return completeName;
    }
    
}
