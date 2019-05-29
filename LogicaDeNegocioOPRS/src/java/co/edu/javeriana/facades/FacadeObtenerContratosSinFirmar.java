/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.RentSignDTO;
import co.edu.javeriana.enums.RentStateEnum;
import co.edu.javeriana.integracion.datos.RentFacadeLocal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author SANTI
 */
@Stateless
public class FacadeObtenerContratosSinFirmar implements FacadeObtenerContratosSinFirmarRemote, FacadeObtenerContratosSinFirmarLocal {
    @EJB
    private RentFacadeLocal rentFacade;
    
    @Override
    public List<RentSignDTO> getContratosSinFirmarCustomer(BigDecimal id) {
        return rentFacade.findByCustomerAndStateDTO(id, BigInteger.valueOf(RentStateEnum.getNO_FIRMADO()));
    }

    @Override
    public List<RentSignDTO> getContratosSinFirmarOwner(BigDecimal id) {
        return rentFacade.findByOwnerAndStateDTO(id, BigInteger.valueOf(RentStateEnum.getNO_FIRMADO()));
    }

    @Override
    public List<RentSignDTO> getContratosFirmadosCustomer(BigDecimal id) {
        return rentFacade.findByCustomerAndStateDTO(id, BigInteger.valueOf(RentStateEnum.getFIRMADO()));
    }

    @Override
    public List<RentSignDTO> getContratosFirmadosOwner(BigDecimal id) {
        return rentFacade.findByOwnerAndStateDTO(id, BigInteger.valueOf(RentStateEnum.getFIRMADO()));
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
