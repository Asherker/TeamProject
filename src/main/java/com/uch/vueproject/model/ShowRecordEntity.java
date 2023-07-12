package com.uch.vueproject.model;

import java.sql.Date;

import lombok.Data;

@Data
public class ShowRecordEntity {
    String id;
    String user;
    String movement;
    Date updateTime;
    String gamename;
    String category;
    int price;
    Date inchange;
    Date outchange;
    int quantity;
    String developer;
    String platform;
    
}
