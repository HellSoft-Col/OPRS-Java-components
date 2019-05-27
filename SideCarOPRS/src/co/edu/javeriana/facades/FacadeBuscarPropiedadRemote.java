/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.PropertyQueryDTO;
import co.edu.javeriana.entities.Property;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author SANTI
 */
@Remote
public interface FacadeBuscarPropiedadRemote {
    public List<Property> searchProperty(PropertyQueryDTO params);
}
