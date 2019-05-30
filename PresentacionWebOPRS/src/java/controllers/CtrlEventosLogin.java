/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import co.edu.javeriana.dtos.LoginDTO;
import com.google.gson.Gson;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import proxies.ProxyLogIn;

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
    
    public String createLoginDto (){
        LoginDTO login = new LoginDTO();
        login.setUsername(username);
        login.setPassword(password);
        
        Gson gson = new Gson();
        String dtoJson = gson.toJson(login);
        ProxyLogIn proxyLogin = new ProxyLogIn();
        Response result = proxyLogin.logIn(dtoJson);
       
        String result_string = new String();
        
        result_string = result.readEntity(String.class);
        
        
        LoginDTO user = gson.fromJson(result_string, LoginDTO.class);
        sessionMap.put("user",user);
        
        if(user.getUsername() == null && (user.getPassword()== null)){
            //TODO: Colocar mensaje de eror
            FacesContext.getCurrentInstance().addMessage("loginForm:loginSubmit", new FacesMessage("Lo sentimos, el usuario no existe"));
             if(user.getUsername()!= this.username && (user.getPassword()== this.password)){
                    FacesContext.getCurrentInstance().addMessage("loginForm:usernameSubmit", new FacesMessage("El usuario no coincide"));
             }else{
                FacesContext.getCurrentInstance().addMessage("loginForm:passSubmit", new FacesMessage("La contraseña no coincide"));
                
            }
            return "index";
        }
        
        //TODO: Agregar Funcionalidad a los botones
        return "PantallaWebMenu";
    }
}
