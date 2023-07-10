package com.uch.vueproject.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class GameListEntity {
    ArrayList<GameEntity> games;
    int total;
}
