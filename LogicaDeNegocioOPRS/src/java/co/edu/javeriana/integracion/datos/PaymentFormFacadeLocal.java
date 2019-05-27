/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.entities.PaymentForm;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SANTI
 */
@Local
public interface PaymentFormFacadeLocal {

    void create(PaymentForm paymentForm);

    void edit(PaymentForm paymentForm);

    void remove(PaymentForm paymentForm);

    PaymentForm find(Object id);

    List<PaymentForm> findAll();

    List<PaymentForm> findRange(int[] range);

    int count();
    
}
