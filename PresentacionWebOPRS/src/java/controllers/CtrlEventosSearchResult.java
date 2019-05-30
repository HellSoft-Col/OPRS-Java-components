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
 * @author Guille
 */
@Named(value = "ctrlEvSR")
@ManagedBean
@SessionScoped
public class CtrlEventosSearchResult {

    /**
     * Creates a new instance of CtrlEventosSearchResult
     */
    public CtrlEventosSearchResult() {
    }
    
    public String rentarP(){        
        return "PantallaWebRP";
    }
    
}
