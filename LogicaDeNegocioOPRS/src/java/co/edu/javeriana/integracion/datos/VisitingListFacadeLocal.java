/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.entities.VisitingList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HellSoft
 */
@Local
public interface VisitingListFacadeLocal {

    void create(VisitingList visitingList);

    void edit(VisitingList visitingList);

    void remove(VisitingList visitingList);

    VisitingList find(Object id);

    List<VisitingList> findAll();

    List<VisitingList> findRange(int[] range);

    int count();
    
}
