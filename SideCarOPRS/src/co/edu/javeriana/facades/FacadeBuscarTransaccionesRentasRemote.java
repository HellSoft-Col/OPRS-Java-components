/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.RentDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author LICHO
 */
@Remote
public interface FacadeBuscarTransaccionesRentasRemote {
    public List<RentDTO> buscarTransaccionesRentas();
}
