/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.PropertyDTO;
import co.edu.javeriana.dtos.PropertyQueryDTO;
import co.edu.javeriana.entities.Property;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HellSoft
 */
@Local
public interface FacadeBuscarPropiedadLocal {
    public List<PropertyDTO> searchProperty(PropertyQueryDTO params);
}
