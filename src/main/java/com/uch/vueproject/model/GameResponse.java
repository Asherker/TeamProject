package com.uch.vueproject.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class GameResponse extends BaseResponse{
    ArrayList<GameEntity> data;

    public GameResponse(int code,String message,ArrayList<GameEntity> data) {
        super(code,message);
        this.data = data;
    }
}
