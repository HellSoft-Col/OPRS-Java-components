/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author LICHO
 */
@Stateless
@LocalBean
public class RentsTimer {
    @EJB
    private FacadeRents facadeRents;

    @Schedule(hour = "*", minute = "*/1")
    
    public void myTimer() {
        try {
            facadeRents.saveAllRents();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        
        System.out.println("Timer event: " + new Date());
    }
}
