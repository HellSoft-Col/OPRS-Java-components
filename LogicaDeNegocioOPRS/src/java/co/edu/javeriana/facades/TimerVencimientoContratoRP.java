/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.facades;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author HellSoft
 */
@Stateless
@LocalBean
public class TimerVencimientoContratoRP {

    @EJB
    private RentPropertyFacadeLocal rentPropertyFacade;

    @Schedule(hour = "*", minute = "*/3")

    public void myTimer() {
        System.out.println("-----------------------------------");
        System.out.println("Timer Vencimiento: ");
        System.out.println("Event: " + new Date());
        rentPropertyFacade.verifyState();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
