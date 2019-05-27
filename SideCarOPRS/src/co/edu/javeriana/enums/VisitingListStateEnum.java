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
public enum VisitingListStateEnum {
    ACTIVA(1),REMOVIDA(2);
    
    private final int value;
    
    private VisitingListStateEnum(int value){
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }

    public static int getACTIVA() {
        return ACTIVA.getValue();
    }

    public static int getREMOVIDA() {
        return REMOVIDA.getValue();
    }

    
    
    
}
