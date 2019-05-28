/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.LoginDTO;
import co.edu.javeriana.integracion.datos.CustomerFacadeLocal;
import co.edu.javeriana.integracion.datos.OwnerFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author sistemas
 */
@Stateless
public class FacadeLogin implements FacadeLoginRemote, FacadeLoginLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private OwnerFacadeLocal ownerFacade;
    private CustomerFacadeLocal customerFacade;

    public LoginDTO iniciarSesion(LoginDTO params){
      LoginDTO login = new LoginDTO();
      if(params.getUsername()!= null && (params.getPassword()!= null)){
          login = customerFacade.findByLogin(params.getUsername(), params.getPassword());
          if(login.getUsername() == null && (login.getPassword() == null)){
              login = ownerFacade.findByLogin(params.getUsername(), params.getPassword());
          }
      }
      return login;
        
    }
    public FacadeLogin(){
        
    }
    
}
