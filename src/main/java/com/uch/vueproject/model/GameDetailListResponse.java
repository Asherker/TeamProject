package com.uch.vueproject.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class GameDetailListResponse extends BaseResponse {
    GameDetailListEntity data;

    public GameDetailListResponse(int code, String message, ArrayList<GameDetailEntity>  games, int total) {
        super(code, message);

        this.data = new GameDetailListEntity();
        this.data.games = games;
        this.data.total = total;
    }
    
}
