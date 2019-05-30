/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.LoginDTO;
import co.edu.javeriana.enums.UserTypeEnum;
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
    @EJB
    private CustomerFacadeLocal customerFacade1;

    @EJB
    private OwnerFacadeLocal ownerFacade;
    
    @Override
    public LoginDTO iniciarSesion(LoginDTO params){
      LoginDTO login = new LoginDTO();
      if(params.getUsername()!= null && (params.getPassword()!= null)){
          login = customerFacade1.findByLogin(params.getUsername(), params.getPassword());
          login.setUser_type(UserTypeEnum.CUSTOMER.getValue());
          if(login.getUsername() == null || login.getPassword() == null){
              login = ownerFacade.findByLogin(params.getUsername(), params.getPassword());
              login.setUser_type(UserTypeEnum.OWNER.getValue());
          }
          System.out.println("------------------------>Este es el username del facade: " + login.getUsername());
      }
      return login;
        
    }
    public FacadeLogin(){
        
    }
    
}
