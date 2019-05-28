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
public enum PropertyLocationEnum {
    Soacha(1),Kennedy(2), Usme(3), Ciudad_Bolivar(4), Bosa(5), Santa_Fe(6);
    private final int value;
    private PropertyLocationEnum(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
    public static String getLocation(int opc){
        String location;
        switch (opc) {
            case 1:  
                location = "Soacha";
                break;
            case 2:  
                location = "Kennedy";
                break;
            case 3:  
                location = "Usme";
                break;
            case 4:  
                location = "Ciudad Bolivar";
                break;
            case 5:  
                location = "Bosa";
                break;
            case 6:  
                location = "Santa fe";
                break;
            default: 
                location = "Invalid location";
                break;
        }
        return location;
    }

    public static PropertyLocationEnum getSoacha() {
        return Soacha;
    }

    public static PropertyLocationEnum getKennedy() {
        return Kennedy;
    }

    public static PropertyLocationEnum getUsme() {
        return Usme;
    }

    public static PropertyLocationEnum getCiudad_Bolivar() {
        return Ciudad_Bolivar;
    }

    public static PropertyLocationEnum getBosa() {
        return Bosa;
    }

    public static PropertyLocationEnum getSanta_Fe() {
        return Santa_Fe;
    }    
}
