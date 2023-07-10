package com.uch.vueproject.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class GameListResponse extends BaseResponse{
    GameListEntity data;

    public GameListResponse(int code, String message, ArrayList<GameEntity>  games, int total) {
        super(code, message);

        this.data = new GameListEntity();
        this.data.games = games;
        this.data.total = total;
    }
}
