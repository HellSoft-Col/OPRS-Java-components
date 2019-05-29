/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.RentSignDTO;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author SANTI
 */
@Remote
public interface FacadeObtenerContratosSinFirmarRemote {
    public List<RentSignDTO> getContratosSinFirmarCustomer(BigDecimal id);
    
    public List<RentSignDTO> getContratosSinFirmarOwner(BigDecimal id);

    public List<RentSignDTO> getContratosFirmadosCustomer(BigDecimal id);

    public List<RentSignDTO> getContratosFirmadosOwner(BigDecimal id);
}
