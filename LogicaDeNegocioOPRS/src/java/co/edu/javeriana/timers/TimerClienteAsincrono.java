/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.timers;

import co.edu.javeriana.dtos.PropertyDTO;
import co.edu.javeriana.dtos.RentsCustomerDTO;
import co.edu.javeriana.facades.FacadeListarPropiedadesLocal;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.Schedule;
import javax.ejb.TimerService;

/**
 *
 * @author anfec
 */
@Stateless
public class TimerClienteAsincrono {

    @Resource
    TimerService timerService;
    @EJB
    FacadeListarPropiedadesLocal facadeListarPropiedades;
    @Schedule(second="*/10", minute="*", hour="*")
    public void automaticTimeout() throws InterruptedException, ExecutionException{
        listRentProperties();
    }
    @Asynchronous
    public void listRentProperties() throws InterruptedException, ExecutionException {
        Future<List<RentsCustomerDTO>> status = facadeListarPropiedades.ListRentPropertiesByUser();
        List<RentsCustomerDTO> lista = status.get();
        System.out.println("===============LLAMADA ASÍNCRONA NUEVA================");
        for (RentsCustomerDTO p : lista){
            System.out.println("*****| Nombre del cosumidor: " + p.getName() + " || CC: " + p.getNdi() + " |*****");
            System.out.println("Dirección: " + p.getProperty().getAddress());
            System.out.println("Lugar: " + p.getProperty().getLocation());
            System.out.println("Renta: " + p.getProperty().getRent());
            System.out.println("Cantidad habitaciones: " + p.getProperty().getRoomsNumber());
            System.out.println("Tipo: " + p.getProperty().getType());            
        }
    }
}
