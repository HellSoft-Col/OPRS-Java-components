/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.dtos;

import java.io.Serializable;

/**
 *
 * @author sistemas
 */
public class RentarRequest implements Serializable {
    private String ndi;
    private String first_name;
    private String last_name;
    private String location_address;
    private String property_address;
    private String rental_time_start;
    private String rental_time_end;
    private Long amount;

    public RentarRequest() {
        
    }
    
    public RentarRequest(String ndi, String first_name, String last_name, String location_addres, String property_addres, String rental_time_start, String rental_time_end, Long amount) {
        this.ndi = ndi;
        this.first_name = first_name;
        this.last_name = last_name;
        this.location_address = location_addres;
        this.property_address = property_addres;
        this.rental_time_start = rental_time_start;
        this.rental_time_end = rental_time_end;
        this.amount = amount;
    }

    public String getNdi() {
        return ndi;
    }

    public void setNdi(String ndi) {
        this.ndi = ndi;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLocation_address() {
        return location_address;
    }

    public void setLocation_address(String location_addres) {
        this.location_address = location_addres;
    }

    public String getProperty_address() {
        return property_address;
    }

    public void setProperty_address(String property_addres) {
        this.property_address = property_addres;
    }

    public String getRental_time_start() {
        return rental_time_start;
    }

    public void setRental_time_start(String rental_time_start) {
        this.rental_time_start = rental_time_start;
    }

    public String getRental_time_end() {
        return rental_time_end;
    }

    public void setRental_time_end(String rental_time_end) {
        this.rental_time_end = rental_time_end;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "RentarRequest{" + "ndi=" + ndi + ", first_name=" + first_name + ", last_name=" + last_name + ", location_addres=" + location_address + ", property_addres=" + property_address + ", rental_time_start=" + rental_time_start + ", rental_time_end=" + rental_time_end + ", amount=" + amount + '}';
    }
}
