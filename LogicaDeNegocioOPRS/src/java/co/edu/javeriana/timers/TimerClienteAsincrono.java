/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.timers;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Future;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;

/**
 *
 * @author anfec
 */
@Stateless
@LocalBean
public class TimerClienteAsincrono {  
    public static void main(String[] args){
        Timer timer = new Timer();
        TimerTaskAsynchronous task = new TimerTaskAsynchronous();
    } 
    
}
