package edu.hit.software.se160132.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.swing.text.html.parser.Entity;

public class EntityType {
    public static final int STOCK_ITEM = 0;
    public static final int SHELF_ITEM = 1;
    public static final int SUPPLIER = 2;
    public static final int CONSUMER = 3;
    public static final int CART = 4;
    public static final int BUYER = 5;
    public static final int PURCHASE = 6;
    public static final int MAIN = 7;
    public static final int STOCK = 8;
    public static final int SHELF = 9;
    public static final int ACCOUNT = 10;
}
