/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import co.edu.javeriana.dtos.LoginDTO;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Guille
 */
@Named(value = "ctrlEventosMenuOwner")
@ManagedBean
@SessionScoped
public class CtrlEventosMenuOwner {
   
    /**
     * Creates a new instance of CtrlEventosMenuOwner
     */
    public CtrlEventosMenuOwner() {
    }
    public String showOwnerName(){
       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
       Map sessionMap = externalContext.getSessionMap();
       LoginDTO currentUser = (LoginDTO) sessionMap.get("user"); 
       String nameOwner = currentUser.getName();
       String lastName = currentUser.getLastName();
       String completeName = "Bienvenido señor propietario/a " + " "+nameOwner + " " + lastName;
       return completeName;
    }
    
}
