/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import co.edu.javeriana.dtos.PropertyDTO;
import co.edu.javeriana.dtos.RentsCustomerDTO;
import co.edu.javeriana.integracion.datos.RentFacadeLocal;
import java.util.List;
import java.util.concurrent.Future;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.SessionContext;

/**
 *
 * @author anfec
 */
@Stateless
@Asynchronous
public class FacadeListarPropiedades implements FacadeListarPropiedadesLocal{

    @EJB
    private RentFacadeLocal rentFacade;
    @Resource
    SessionContext ctx;   
    
    @Override
    public Future<List<RentsCustomerDTO>> ListRentPropertiesByUser(){
        if (ctx.wasCancelCalled()) {
            return new AsyncResult<>(null);
        }
        List<RentsCustomerDTO> rentProperties = rentFacade.findRentPropertiesByNdi();
        return new AsyncResult<>(rentProperties);
    }
}
