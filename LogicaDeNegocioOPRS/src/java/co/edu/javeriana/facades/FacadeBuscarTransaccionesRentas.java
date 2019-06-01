/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.RentDTO;
import co.edu.javeriana.integracion.datos.RentFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HellSoft
 */
@Stateless
public class FacadeBuscarTransaccionesRentas implements FacadeBuscarTransaccionesRentasRemote {
    
    @EJB
    private RentFacadeLocal rentFacade;

    @Override
    public List<RentDTO> buscarTransaccionesRentas(){
       List<RentDTO> transaccionesRentas = rentFacade.findRentTransactions();
       return transaccionesRentas;
    }
}
