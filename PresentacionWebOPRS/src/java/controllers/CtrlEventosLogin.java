/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author HellSoft
 */
@Named("ctrlEventosLogin")
@ManagedBean
@SessionScoped
public class CtrlEventosLogin {

    /**
     * Creates a new instance of CtrlEventosLogin
     */
    private String username;
    private String password;
    
    public CtrlEventosLogin() {
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
    
    
}
