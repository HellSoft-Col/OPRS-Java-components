/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.LoginDTO;
import javax.ejb.Local;

/**
 *
 * @author sistemas
 */
@Local
public interface FacadeLoginLocal {
    public LoginDTO iniciarSesion(LoginDTO params);
    
}
