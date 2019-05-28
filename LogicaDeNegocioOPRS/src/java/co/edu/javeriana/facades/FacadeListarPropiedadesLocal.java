/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.PropertyDTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anfec
 */
@Local
public interface FacadeListarPropiedadesLocal {
    public List<PropertyDTO> ListRentPropertiesByUser(String cedula);
}
