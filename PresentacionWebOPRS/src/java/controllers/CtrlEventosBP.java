/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import co.edu.javeriana.dtos.PropertyQueryDTO;
import co.edu.javeriana.enums.PropertyTypeEnum;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sistemas
 */
@Named(value = "ctrlEventosBP")
@ManagedBean
@SessionScoped
public class CtrlEventosBP {

    private PropertyQueryDTO dtoProperty;
    private PropertyTypeEnum propertyType;
    private String location;
    private String numRooms;
    private String minRent;
    private String maxRent;
    
    public CtrlEventosBP() {
    }
    
    public PropertyTypeEnum getPropertyType() {
        return propertyType;
    }

    public String getLocation() {
        return location;
    }

    public String getNumRooms() {
        return numRooms;
    }

    public String getMinRent() {
        return minRent;
    }

    public String getMaxRent() {
        return maxRent;
    }

    public PropertyQueryDTO createDtoProperty() {
        PropertyQueryDTO dtoP = new PropertyQueryDTO();
        dtoP.setLocation(location);
        dtoP.setPropertyType(propertyType.getValue());
        dtoP.setRoomsNumber(new Integer(this.numRooms));
        dtoP.setMinimalRent(new Integer(this.minRent));
        dtoP.setMaximalRent(new Integer(this.maxRent));
        return dtoProperty;
    }
    
}
