/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author HellSoft
 */
public class LoginDTO implements Serializable{
    private String username;
    private String password;
    private BigDecimal id;
    private String name;
    private String lastName;
    private String ndi;
    private String email;
    private int user_type;
    
    public LoginDTO() {
        this.username = null;
        this.password = null;
    }
    
    public LoginDTO(String username, String password, BigDecimal id, String name, String lastName, String ndi, String email) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.ndi = ndi;
        this.email = email;
    }

     public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNdi() {
        return ndi;
    }

    public void setNdi(String ndi) {
        this.ndi = ndi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
