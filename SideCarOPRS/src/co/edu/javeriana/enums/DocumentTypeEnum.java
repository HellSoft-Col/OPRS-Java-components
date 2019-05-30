/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.enums;

/**
 *
 * @author SANTI
 */
public enum DocumentTypeEnum {
    CEDULA(1), CEDULA_EXTRANJERIA(2), TARJETA_IDENTIDAD(3);

    private final int value;
    
    public int getValue(){
        return value;
    }

    private DocumentTypeEnum(int value) {
        this.value = value;
    }
    
    public static String getDocumentType(int opc){
        String documento;
        switch (opc) {
            case 1:  
                documento = "Cedula de ciudadania";
                break;
            case 2:  
                documento = "Cedula de extranjeria";
                break;
            case 3:  
                documento = "Tarjeta de identidad";
                break;
            default: 
                documento = "Documento invalido";
                break;
        }
        return documento;
    }

    public static DocumentTypeEnum getCEDULA() {
        return CEDULA;
    }

    public static DocumentTypeEnum getCEDULA_EXTRANJERIA() {
        return CEDULA_EXTRANJERIA;
    }

    public static DocumentTypeEnum getTARJETA_IDENTIDAD() {
        return TARJETA_IDENTIDAD;
    }

    
    
}
