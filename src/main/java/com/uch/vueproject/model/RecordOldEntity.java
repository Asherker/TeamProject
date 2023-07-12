package com.uch.vueproject.model;

import java.sql.Date;

import lombok.Data;

@Data
public class RecordOldEntity {
    String id;
    String gamename;
    String category;
    int price;
    Date inchange;
    Date outchange;
    int quantity;
    String developer;
    String platform;
    
}
