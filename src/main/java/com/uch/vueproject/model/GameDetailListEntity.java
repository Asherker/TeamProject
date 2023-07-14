package com.uch.vueproject.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class GameDetailListEntity {
    ArrayList<GameDetailEntity> games;
    int total;
    
}
