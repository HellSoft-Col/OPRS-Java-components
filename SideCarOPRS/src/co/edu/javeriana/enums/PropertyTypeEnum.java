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
    
    public String getName(PropertyTypeEnum enu){
        if(enu.getValue() == 1){
            return "Casa";
        }else if(enu.getValue() == 2){
            return "Apartamento";
        }

        return "";
    }
    
    public static String getStringName(int opc){
        String name = "";
        if(opc == 1){
            name = "Casa";
        }
        else if(opc == 2){
            name = "Apartamento";
        }
        return name;
    }
    
}
