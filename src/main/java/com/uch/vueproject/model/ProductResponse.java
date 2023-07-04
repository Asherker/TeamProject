package com.uch.vueproject.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ProductResponse {
    int code;
    String message;
    ArrayList<ProductEntity> data;

    public ProductResponse(int code, String message, ArrayList<ProductEntity> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
