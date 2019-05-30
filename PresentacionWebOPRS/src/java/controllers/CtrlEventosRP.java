/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import co.edu.javeriana.dtos.LoginDTO;
import co.edu.javeriana.dtos.PropertyDTO;
import co.edu.javeriana.dtos.RentPropertyDTO;
import co.edu.javeriana.dtos.RentarRequest;
import co.edu.javeriana.facades.FRentarPropiedadRemote;
import com.google.gson.Gson;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import proxies.ProxyRP;

/**
 *
 * @author sistemas
 */
@ManagedBean
@SessionScoped
public class CtrlEventosRP implements Serializable{
    private String ndi/* PANTALLA */;
    private String account_password /* PANTALLA */;
    private int type;
    private String rentalTimeEnd/* PANTALLA */;
    private String rentalTimeStart/* PANTALLA */;
    
    public CtrlEventosRP() {
    }

    public String getNdi() {
        return ndi;
    }

    public void setNdi(String ndi) {
        this.ndi = ndi;
    }

    public String getAccount_password() {
        return account_password;
    }

    public void setAccount_password(String account_password) {
        this.account_password = account_password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRentalTimeEnd() {
        return rentalTimeEnd;
    }

    public void setRentalTimeEnd(String rentalTimeEnd) {
        this.rentalTimeEnd = rentalTimeEnd;
    }

    public String getRentalTimeStart() {
        return rentalTimeStart;
    }

    public void setRentalTimeStart(String rentalTimeStart) {
        this.rentalTimeStart = rentalTimeStart;
    }
    
    public void sendPaymentForm(){
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map sessionMap = externalContext.getSessionMap();
        PropertyDTO property = (PropertyDTO)sessionMap.get("property");
        LoginDTO user = (LoginDTO)sessionMap.get("user");
        BigInteger propertyId = property.getId();
        BigInteger propertyOwnerId = property.getOwner_id();
        BigDecimal userId = user.getId();
        BigInteger customerId = userId.toBigInteger();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        String rentalDate = dtf.format(now);
        
        String rentalTimeStart = this.rentalTimeStart;
        String rentalTimeEnd = this.rentalTimeEnd;
        BigDecimal rentProperty = property.getRent();
        String ndi = user.getNdi();
        String account_password = this.account_password;
        int type = this.type;
        
        
        RentPropertyDTO rentP = new RentPropertyDTO(propertyId,propertyOwnerId, customerId, rentalDate,  rentalTimeStart, rentalTimeEnd, rentProperty, ndi, account_password, type);
        Gson gson = new Gson();
        String dtoJson = gson.toJson(rentP);
        
        ProxyRP proxyRP = new ProxyRP();
        Response result = proxyRP.createNewRent(dtoJson);
        
        if (result.getStatus() != Response.Status.OK.getStatusCode()){
            //TODO: Devolver error 
        }
        
        //TODO: Devolver Todo OK
        
    }
    
    
}
