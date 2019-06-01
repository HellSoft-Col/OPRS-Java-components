/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import co.edu.javeriana.dtos.LoginDTO;
import co.edu.javeriana.dtos.PaymentResponseDTO;
import co.edu.javeriana.dtos.PropertyDTO;
import co.edu.javeriana.dtos.RentPropertyDTO;
import co.edu.javeriana.dtos.RentarRequest;
import co.edu.javeriana.facades.FRentarPropiedadRemote;
import com.google.gson.Gson;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import proxies.ProxyRP;

/**
 *
 * @author HellSoft
 */
@ManagedBean
@SessionScoped
public class CtrlEventosRP implements Serializable {

    private String ndi/* PANTALLA */;
    private String account_password /* PANTALLA */;
    private int type;
    private Date rentalTimeEnd/* PANTALLA */;
    private Date rentalTimeStart/* PANTALLA */;

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

    public Date getRentalTimeEnd() {
        return rentalTimeEnd;
    }

    public void setRentalTimeEnd(Date rentalTimeEnd) {
        this.rentalTimeEnd = rentalTimeEnd;
    }

    public Date getRentalTimeStart() {
        return rentalTimeStart;
    }

    public void setRentalTimeStart(Date rentalTimeStart) {
        this.rentalTimeStart = rentalTimeStart;
    }

    public void sendPaymentForm() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map sessionMap = externalContext.getSessionMap();
        PropertyDTO property = (PropertyDTO) sessionMap.get("property");
        LoginDTO user = (LoginDTO) sessionMap.get("user");
        BigInteger propertyId = property.getId();
        BigInteger propertyOwnerId = property.getOwner_id();
        BigDecimal userId = user.getId();
        BigInteger customerId = userId.toBigInteger();

        SimpleDateFormat dtf = new SimpleDateFormat("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        String rentalDate = dtf.format(now);

        String rentalTimeStart = dtf.format(this.rentalTimeStart);
        String rentalTimeEnd = dtf.format(this.rentalTimeEnd);
        BigDecimal rentProperty = property.getRent();
        String ndi = user.getNdi();
        String account_password = this.account_password;
        int type = this.type;

        RentPropertyDTO rentP = new RentPropertyDTO(propertyId, propertyOwnerId, customerId, rentalDate, rentalTimeStart, rentalTimeEnd, rentProperty, ndi, account_password, type);
        Gson gson = new Gson();

        String dtoJson = gson.toJson(rentP);
        System.out.println("--->" + dtoJson);
        ProxyRP proxyRP = new ProxyRP();
        Response result = proxyRP.createNewRent(dtoJson);

        if (result.getStatus() != Response.Status.OK.getStatusCode()) {
            FacesContext.getCurrentInstance().addMessage("rpForm:rSubmit", new FacesMessage("Su solicitud ha sido rechazada :( probablemente por problemas en el pago."));
        } else {
            String result_string = new String();
            result_string = result.readEntity(String.class);
            PaymentResponseDTO dto = gson.fromJson(result_string, PaymentResponseDTO.class);
            //TODO : Mostrar en pantalla mensaje
            FacesContext.getCurrentInstance().addMessage("rpForm:rSubmit", new FacesMessage("Su solicitud de rentar propiedad esta en proceso, por favor revise su correo para seguir las instrucciones :). Datos bancarios: No. Confirmacion: "+ dto.getNumAprobacion() + " y se aprono el "+ dto.getAprobacion()));
        }

    }

}
