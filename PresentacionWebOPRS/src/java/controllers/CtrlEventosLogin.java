/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import co.edu.javeriana.dtos.LoginDTO;
import com.google.gson.Gson;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
    
    public LoginDTO createLoginDto (){
        LoginDTO login = new LoginDTO();
        login.setUsername(username);
        login.setPassword(password);
        
        Gson gson = new Gson();
        String dtoJson = gson.toJson(login);
        ProxyLogIn proxyLogin = new ProxyLogIn();
        Response response = proxyLogin.logIn(dtoJson);
        
        
//String result = EntityUtils.toString(response.getEntity());
        LoginDTO user = gson.fromJson(response, LoginDTO.class);
        return login;
    }
}
