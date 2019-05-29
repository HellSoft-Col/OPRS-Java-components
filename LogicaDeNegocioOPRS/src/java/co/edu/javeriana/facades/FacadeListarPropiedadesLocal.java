/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.PropertyDTO;
import co.edu.javeriana.dtos.RentsCustomerDTO;
import java.util.List;
import java.util.concurrent.Future;
import javax.ejb.Asynchronous;
import javax.ejb.Local;

/**
 *
 * @author anfec
 */
@Local
public interface FacadeListarPropiedadesLocal {
    
    public Future<List<RentsCustomerDTO>> ListRentPropertiesByUser();
}
