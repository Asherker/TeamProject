package com.uch.vueproject.model;

import lombok.Data;

@Data
public class ProductEntity {
    int id;
    String name;
    String imageUrl; // Field (欄位)
    String description;
    String category;
    int price;
    String storeName;
}
