/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import co.edu.javeriana.dtos.PropertyQueryDTO;
import co.edu.javeriana.entities.Property;
import co.edu.javeriana.enums.PropertyTypeEnum;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import proxies.ProxyBP;

/**
 *
 * @author sistemas
 */
@Named(value = "ctrlEventosBP")
@ManagedBean
@SessionScoped
public class CtrlEventosBP {
     
    private PropertyQueryDTO dtoProperty;
    private String idCard;
    private String minRent;
    private String maxRent;
    
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
    

    public List<Property>  createDtoProperty() {
        PropertyQueryDTO dtoP = new PropertyQueryDTO();
        dtoP.setCedulaProp(idCard);
        dtoP.setMinimalRent(new Integer(this.minRent));
        dtoP.setMaximalRent(new Integer(this.maxRent));
        
        Type listTypeProperty = new TypeToken<ArrayList<Property>>() {}.getType();
        
        Gson gson = new Gson();
	String dtoJson = gson.toJson(dtoP);
        
        ProxyBP proxyBp = new ProxyBP();
        String response = proxyBp.searchProperties_JSON(dtoJson, String.class);
        List<Property> result = gson.fromJson(response, listTypeProperty);
        
        
        return result;
    }
    
    
    
}
