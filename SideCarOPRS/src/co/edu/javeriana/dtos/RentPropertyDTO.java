/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.dtos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author SANTI
 */
public class RentPropertyDTO implements Serializable {

    private String type_credit_card;
    private String credit_card_number;
    private String name_holder;
    private Date expiry_date;
    private int customer_id;
    
    
    
    
    public String getType_credit_card() {
        return type_credit_card;
    }

    public void setType_credit_card(String type_credit_card) {
        this.type_credit_card = type_credit_card;
    }

    public String getCredit_card_number() {
        return credit_card_number;
    }

    public void setCredit_card_number(String credit_card_number) {
        this.credit_card_number = credit_card_number;
    }

    public String getName_holder() {
        return name_holder;
    }

    public void setName_holder(String name_holder) {
        this.name_holder = name_holder;
    }

    public Date getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    
}
