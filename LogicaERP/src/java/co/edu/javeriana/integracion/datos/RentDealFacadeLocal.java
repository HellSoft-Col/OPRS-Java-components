/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.entities.RentDeal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pabloarizaluna
 */
@Local
public interface RentDealFacadeLocal {

    void create(RentDeal rentDeal);

    void edit(RentDeal rentDeal);

    void remove(RentDeal rentDeal);

    RentDeal find(Object id);

    List<RentDeal> findAll();

    List<RentDeal> findRange(int[] range);

    int count();
    
}
