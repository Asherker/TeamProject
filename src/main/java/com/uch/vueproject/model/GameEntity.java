package com.uch.vueproject.model;

import java.sql.Date;

import lombok.Data;
@Data
public class GameEntity {
    int id;
    String name;
    String category;
    int price;
    Date inchange;
    Date outchange;
    int quantity;
    String developer;
}
