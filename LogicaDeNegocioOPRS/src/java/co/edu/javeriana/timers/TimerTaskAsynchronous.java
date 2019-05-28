/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.timers;

import co.edu.javeriana.dtos.PropertyDTO;
import co.edu.javeriana.facades.FacadeListarPropiedades;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.Future;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.SessionContext;

/**
 *
 * @author anfec
 */
@Asynchronous
public class TimerTaskAsynchronous extends TimerTask{

    @Resource
    SessionContext ctx ;  
    
    @EJB
    FacadeListarPropiedades facadeListaPropiedades;
    
    @Override
    public void run() {
        listRentProperties("1059638459");
    }
    
    public Future<List<PropertyDTO>> listRentProperties(String ndi) {
        List<PropertyDTO> listP = facadeListaPropiedades.ListRentPropertiesByUser(ndi);
        if ( ctx. wasCancelCalled() ) {
            return new AsyncResult<>(null);
        }
        return new AsyncResult<>(listP);
    }
    
}
