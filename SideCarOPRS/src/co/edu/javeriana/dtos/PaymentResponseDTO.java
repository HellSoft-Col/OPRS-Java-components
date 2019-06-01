/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.dtos;

import java.io.Serializable;

/**
 *
 * @author HellSoft
 */
public class PaymentResponseDTO implements Serializable{
    private String numAprobacion;
    private String aprobacion;

    public PaymentResponseDTO() {
        this.numAprobacion = null;
        this.aprobacion = null;
    }
    
    public PaymentResponseDTO(String numAprobacion, String aprobacion) {
        this.numAprobacion = numAprobacion;
        this.aprobacion = aprobacion;
    }
    
    public String getNumAprobacion() {
        return numAprobacion;
    }

    public void setNumAprobacion(String numAprobacion) {
        this.numAprobacion = numAprobacion;
    }

    public String getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(String aprobacion) {
        this.aprobacion = aprobacion;
    }
    
    
}
