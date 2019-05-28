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

   /*public LoginDTO iniciarsesion(LoginDTO params){
      customerFacade.findByLogin(params.getUsername(), params.getPassword());
      return ;
        
    }*/
    public FacadeLogin(){
        
    }
    
}
