/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import co.edu.javeriana.dtos.PropertyDTO;
import co.edu.javeriana.dtos.PropertyQueryDTO;
import co.edu.javeriana.entities.Property;
import co.edu.javeriana.enums.PropertyTypeEnum;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import proxies.ProxyBP;

/**
 *
 * |@author HellSoft
 */
@Named(value = "ctrlEventosBP")
@ManagedBean
@SessionScoped
public class CtrlEventosBP implements Serializable{

    private PropertyQueryDTO dtoProperty;
    private String idCard;
    private String minRent;
    private String maxRent;
    private List<PropertyDTO> properties;

    public List<PropertyDTO> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyDTO> properties) {
        this.properties = properties;
    }

    public CtrlEventosBP() {
    }

    public String getIdCard() {
        return idCard;
    }

    public String getMinRent() {
        return minRent;
    }

    public String getMaxRent() {
        return maxRent;
    }

    public void setDtoProperty(PropertyQueryDTO dtoProperty) {
        this.dtoProperty = dtoProperty;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setMinRent(String minRent) {
        this.minRent = minRent;
    }

    public void setMaxRent(String maxRent) {
        this.maxRent = maxRent;
    }

    public boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public Map<Integer, String> getMapOfIType() {
        Map<Integer, String> mapOfItem = new HashMap<>();

        mapOfItem.put(1, "Casa");
        mapOfItem.put(2, "Apartamento");

        return mapOfItem;
    }

    public String propertyTypeName(int val) {
        return getMapOfIType().get(val);
    }

    public String createDtoProperty() {
        PropertyQueryDTO dtoP = new PropertyQueryDTO();

        if (idCard.length() >= 8) {
            dtoP.setCedulaProp(idCard);
        }

        if (isNumeric(this.minRent) && isNumeric(this.maxRent)) {
            dtoP.setMinimalRent(new Integer(this.minRent));
            dtoP.setMaximalRent(new Integer(this.maxRent));
        }

        Type listTypeProperty = new TypeToken<ArrayList<PropertyDTO>>() {
        }.getType();

        Gson gson = new Gson();
        String dtoJson = gson.toJson(dtoP);

        ProxyBP proxyBp = new ProxyBP();
        String response = proxyBp.searchProperties_JSON(dtoJson, String.class);
        List<PropertyDTO> result = gson.fromJson(response, listTypeProperty);

        this.properties = result;

        return "PantallaSearchResult";
    }
    public String rentarP(PropertyDTO property){
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map sessionMap = externalContext.getSessionMap();
        sessionMap.put("property", property);
        return "PantallaWebRP";
    }

}
