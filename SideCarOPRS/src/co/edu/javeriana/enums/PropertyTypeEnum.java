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
public enum PropertyTypeEnum {
    CASA(1),APARTAMENTO(2);
    private final int value;
    private PropertyTypeEnum(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }

    public static int getCASA() {
        return CASA.getValue();
    }

    public static int getAPARTAMENTO() {
        return APARTAMENTO.getValue();
    }
    
    
}
