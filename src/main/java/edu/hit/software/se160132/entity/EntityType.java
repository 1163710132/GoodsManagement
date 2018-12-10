package edu.hit.software.se160132.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.swing.text.html.parser.Entity;

public enum EntityType {
    ACCOUNT,
    GOODS,
    PO_SET, PO,
    SO_SET, SO,
    SHELF, SHELF_DELIVER, SHELF_ITEM, SHELF_SUPPLY,
    STOCK, STOCK_DELIVER, STOCK_ITEM, STOCK_SUPPLY,
    STORE;

    @JsonValue
    public Integer getValue(){
        return this.ordinal();
    }

    @JsonCreator
    public static EntityType getByValue(Integer value){
        if(value == null){
            return null;
        }
        EntityType[] values = values();
        if(values.length <= value || value < 0){
            return null;
        }else{
            return values[value];
        }
    }
}
