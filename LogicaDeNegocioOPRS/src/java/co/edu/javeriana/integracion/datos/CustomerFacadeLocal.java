/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.dtos.LoginDTO;
import co.edu.javeriana.entities.Customer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HellSoft
 */
@Local
public interface CustomerFacadeLocal {

    void create(Customer customer);

    void edit(Customer customer);

    void remove(Customer customer);

    Customer find(Object id);
    
    LoginDTO findByLogin(String username, String password);
    
    List<Customer> findAll();

    List<Customer> findRange(int[] range);

    int count();
    
    public Customer findById(int id) throws Exception; 
   
}
