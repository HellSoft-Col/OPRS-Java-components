/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.enums;

/**
 *
 * @author sistemas
 */
public enum RentStateEnum {
    FIRMADO(1),TERMINADO(2),EN_CONTRATO(3),EXPIRADO(4);
    
    private final int value;
    
    private RentStateEnum(int value){
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }

    public static int getFIRMADO() {
        return FIRMADO.getValue();
    }

    public static int getTERMINADO() {
        return TERMINADO.getValue();
    }

    public static int getEN_CONTRATO() {
        return EN_CONTRATO.getValue();
    }

    public static int getEXPIRADO() {
        return EXPIRADO.getValue();
    }

    
    
    
}
