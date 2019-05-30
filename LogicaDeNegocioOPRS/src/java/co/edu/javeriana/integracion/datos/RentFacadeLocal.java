/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.integracion.datos;

import co.edu.javeriana.dtos.RentSignDTO;
import co.edu.javeriana.dtos.RentDTO;
import co.edu.javeriana.entities.Rent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HellSoft
 */
@Local
public interface RentFacadeLocal {

    void create(Rent rent) throws Exception;

    void edit(Rent rent);

    void remove(Rent rent);

    Rent find(Object id);

    List<Rent> findAll();

    List<Rent> findRange(int[] range);

    int count();

    List<Rent> findByCustomerAndState(BigDecimal id, BigInteger state);

    List<RentSignDTO> findByCustomerAndStateDTO(BigDecimal id, BigInteger state);

    List<Rent> findByOwnerAndState(BigDecimal id, BigInteger state);

    List<RentSignDTO> findByOwnerAndStateDTO(BigDecimal id, BigInteger state);

    public Rent findById(int id);

    public List<Rent> findByState(BigInteger state);

    public List<RentDTO> findRentTransactions();

}
