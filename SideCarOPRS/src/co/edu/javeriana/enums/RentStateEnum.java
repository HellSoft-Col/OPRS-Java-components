/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.enums;

/**
 *
 * @author HellSoft
 */
public enum RentStateEnum {
    FIRMADO(1),TERMINADO(2),EN_CONTRATO(3),EXPIRADO(4), NO_FIRMADO(0);
    
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
    
    public static String getState(int opc){
        String state = null;
        switch (opc){
            case 1:  
                state = "Firmado";
                break;
            case 2:  
                state = "Terminado";
                break;
            case 3:  
                state = "En contrato";
                break;
            case 4:  
                state = "Expirado";
                break;
            default: 
                state = "Invalid state";
                break;
        }
        return state;
    }

    public static int getNO_FIRMADO() {
        return NO_FIRMADO.getValue();
    }
    
    
    
    
}
