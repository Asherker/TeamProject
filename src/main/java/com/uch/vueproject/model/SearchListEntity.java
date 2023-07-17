package com.uch.vueproject.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class SearchListEntity {

    ArrayList<SearchEntity> shows;
    int total;
    
}
