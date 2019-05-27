/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import co.edu.javeriana.entities.Property;
import co.edu.javeriana.entities.PropertyPK;
import co.edu.javeriana.facades.FacadeAgregarPropiedadRemote;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author LICHO
 */
@ManagedBean
@RequestScoped
public class CtrlEventosAP {
    
    @EJB
    FacadeAgregarPropiedadRemote fapr;
    
    private BigInteger type;
    private String address;
    private String location;
    private BigInteger rooms;
    private BigDecimal rent;
    private BigInteger owner;
    
    /**
     * Creates a new instance of CtrlEventosAP
     */
    public CtrlEventosAP() {
    }

    public FacadeAgregarPropiedadRemote getFapr() {
        return fapr;
    }

    public void setFapr(FacadeAgregarPropiedadRemote fapr) {
        this.fapr = fapr;
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

    
    
    public void addProperty(){
        //TODO: get owner id
        this.owner = BigInteger.valueOf(1);
        PropertyPK ppk = new PropertyPK(owner);
        Property property = new Property(ppk, type, address, rooms, rent, location);
        fapr.addProperty(property);
    }
    
}
