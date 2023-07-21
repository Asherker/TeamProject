package com.uch.vueproject.model;

import java.sql.Date;

import lombok.Data;
@Data
public class GameEntity {
    String id;
    String chname;
    // String enname;
    String platform;
    String category;
    String developer;
    // int devyear;
    int price;
    int quantity;
    Date inchange;
    Date outchange;
    // String description;
   
    
    
    
}
