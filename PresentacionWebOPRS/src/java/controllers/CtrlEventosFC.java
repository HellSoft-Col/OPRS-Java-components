/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import co.edu.javeriana.dtos.LoginDTO;
import co.edu.javeriana.dtos.PropertyDTO;
import co.edu.javeriana.dtos.RentSignDTO;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author SANTI
 */
@Named(value = "ctrlEventosFC")
@ManagedBean
@RequestScoped
public class CtrlEventosFC implements Serializable{

    private List<RentSignDTO> unsigned_rents;

    public List<RentSignDTO> getUnsigned_rents() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map sessionMap = externalContext.getSessionMap();
        
        LoginDTO user = (LoginDTO)sessionMap.get("user");
      
        
        return unsigned_rents;
    }

    public void setUnsigned_rents(List<RentSignDTO> unsigned_rents) {
        this.unsigned_rents = unsigned_rents;
    }
    
    public CtrlEventosFC() {
    }
    
    public void SignContract(BigInteger lease_id){
        //TODO:
    }
    
}
