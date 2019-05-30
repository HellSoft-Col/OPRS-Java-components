/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import co.edu.javeriana.dtos.LeaseUtilityDTO;
import co.edu.javeriana.dtos.LoginDTO;
import co.edu.javeriana.dtos.PropertyDTO;
import co.edu.javeriana.dtos.RentSignDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import proxies.ProxyBuscarContratosUsuario;
import proxies.ProxyFC;

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
        Gson gson = new Gson();
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map sessionMap = externalContext.getSessionMap();
        
        LoginDTO user = (LoginDTO)sessionMap.get("user");
        ProxyBuscarContratosUsuario proxie = new ProxyBuscarContratosUsuario();
        
        Type listTypeProperty = new TypeToken<ArrayList<RentSignDTO>>() {
        }.getType();
        String response = proxie.getUnsignedLeasesCustomer(String.class, user.getId().toString());
        this.unsigned_rents = gson.fromJson(response, listTypeProperty);
        
        return unsigned_rents;
    }

    public void setUnsigned_rents(List<RentSignDTO> unsigned_rents) {
        this.unsigned_rents = unsigned_rents;
    }
    
    public CtrlEventosFC() {
    }
    
    public void SignContract(BigInteger lease_id){
        System.out.println("---> "+ lease_id.toString());
        ProxyFC proxie = new ProxyFC();
        LeaseUtilityDTO params = new LeaseUtilityDTO();
        params.setLease_id(lease_id);
        Gson gson = new Gson();
        String json = gson.toJson(params);
        Response result = proxie.signLease(json);
        
        if (result.getStatus() != Response.Status.OK.getStatusCode()){
            FacesContext.getCurrentInstance().addMessage("fcForm:fcSubmit", new FacesMessage("El contrato no existe:("));
            //TODO: Devolver error 
        }else{
            FacesContext.getCurrentInstance().addMessage("fcForm:fcSubmit", new FacesMessage("El contrato ya ha sido firmado, gracias :)"));
        }
        
        //TODO: Devolver Todo OK
        
    }
    
}
