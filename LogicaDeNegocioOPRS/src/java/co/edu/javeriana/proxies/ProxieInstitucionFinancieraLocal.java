/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.proxies;

import co.edu.javeriana.dtos.PaymentDTO;
import co.edu.javeriana.dtos.PaymentResponseDTO;
import javax.ejb.Local;

/**
 *
 * @author HellSoft
 */
@Local
public interface ProxieInstitucionFinancieraLocal {
    public PaymentResponseDTO solicitarConfirmacionPago(PaymentDTO params);
}
