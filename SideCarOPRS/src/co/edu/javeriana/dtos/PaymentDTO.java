/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.dtos;

import java.io.Serializable;

/**
 *
 * @author SANTI
 */
public class PaymentDTO implements Serializable{
    private String tipoDocumento;
    private String numDocumento;
    private String contraseña;
    private int monto;

    public PaymentDTO() {
        this.tipoDocumento = null;
        this.numDocumento = null;
        this.contraseña = null;
        this.monto = -1;
    }
    
    public PaymentDTO(String tipoDocumento, String numDocumento, String contraseña, int monto) {
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.contraseña = contraseña;
        this.monto = monto;
    }
    
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    
}
