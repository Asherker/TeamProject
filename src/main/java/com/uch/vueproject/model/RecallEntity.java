package com.uch.vueproject.model;

import java.sql.Date;

import lombok.Data;

@Data
public class RecallEntity {
    String id;
    String name;
    String platform;
    String category;
    String developer;
    int price;
    int quantity;
    Date inchange;
    Date outchange;
    Date finalupdate;
}
