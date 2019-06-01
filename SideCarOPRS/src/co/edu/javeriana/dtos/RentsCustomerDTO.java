/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anfec
 */
@XmlRootElement
public class RentsCustomerDTO implements Serializable{
    private PropertyDTO property;
    private String name;
    private String ndi;

    public RentsCustomerDTO(String address, String location, BigDecimal rent, BigInteger roomsNumber, BigInteger type, String name, String ndi) {
        this.property = new PropertyDTO(address, location, rent, roomsNumber, type);
        this.name = name;
        this.ndi = ndi;
    }

    public PropertyDTO getProperty() {
        return property;
    }

    public void setProperty(PropertyDTO property) {
        this.property = property;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNdi() {
        return ndi;
    }

    public void setNdi(String ndi) {
        this.ndi = ndi;
    }
    
    
}
