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
public enum UserTypeEnum {
    OWNER(1), CUSTOMER(2);
    
    private final int value;
    
    UserTypeEnum(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public static UserTypeEnum getOWNER() {
        return OWNER;
    }

    public static UserTypeEnum getCUSTOMER() {
        return CUSTOMER;
    }
    
    
}
