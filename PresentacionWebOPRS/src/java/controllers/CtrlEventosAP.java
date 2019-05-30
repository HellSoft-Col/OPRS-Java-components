/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import co.edu.javeriana.dtos.LoginDTO;
import co.edu.javeriana.entities.Property;
import co.edu.javeriana.entities.PropertyPK;
import co.edu.javeriana.enums.PropertyLocationEnum;
import co.edu.javeriana.facades.FacadeAgregarPropiedadRemote;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author LICHO
 */
@ManagedBean
@SessionScoped
public class CtrlEventosAP {

    FacadeAgregarPropiedadRemote facadeAgregarPropiedad = lookupFacadeAgregarPropiedadRemote();
    private BigInteger type;
    private String address;
    private String location;
    private BigInteger rooms;
    private BigDecimal rent;
    private BigInteger owner;
    private List<String> locationNames;
 
    
    @PostConstruct
    public void init() {
        locationNames = new ArrayList<>();
        for(int i=1; i<7; i++){
            locationNames.add(PropertyLocationEnum.getLocation(i));
        }
    }
    
    /**
     * Creates a new instance of CtrlEventosAP
     */
    public CtrlEventosAP() {
    }

    public BigInteger getType() {
        return type;
    }

    public void setType(BigInteger type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigInteger getRooms() {
        return rooms;
    }

    public void setRooms(BigInteger rooms) {
        this.rooms = rooms;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public BigInteger getOwner() {
        return owner;
    }

    public void setOwner(BigInteger owner) {
        this.owner = owner;
    }

    public List<String> getLocationNames() {
        return locationNames;
    }

    public void setLocationNames(List<String> locationNames) {
        this.locationNames = locationNames;
    }
    
    public void addProperty(){
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map sessionMap = externalContext.getSessionMap();
        LoginDTO currentUser = (LoginDTO)sessionMap.get("user");
        BigDecimal userId = currentUser.getId();
        BigInteger ownerId = userId.toBigInteger();
        
        this.owner = ownerId;
       
        System.out.println("-----------------------------------> Este es el Id del owner: " + this.owner);
        PropertyPK ppk = new PropertyPK(owner);
        //TODO: try to delete this shit :V
        ppk.setId(BigInteger.valueOf(999));
        Property property = new Property(ppk, type, address, rooms, rent, location);
        boolean ans = facadeAgregarPropiedad.addProperty(property);
        if(!ans){
            FacesContext.getCurrentInstance().addMessage("apForm:pSubmit", new FacesMessage("Algo salió mal :(")); 
        }
        else{
            FacesContext.getCurrentInstance().addMessage("apForm:pSubmit", new FacesMessage("Se le notificará al correo el resultado de la operación")); 
        }
        
    }
    
    private FacadeAgregarPropiedadRemote lookupFacadeAgregarPropiedadRemote() {
        try {
            javax.naming.Context c = new InitialContext();
            return (FacadeAgregarPropiedadRemote) c.lookup("java:global/LogicaDeNegocioOPRS/FacadeAgregarPropiedad!co.edu.javeriana.facades.FacadeAgregarPropiedadRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
