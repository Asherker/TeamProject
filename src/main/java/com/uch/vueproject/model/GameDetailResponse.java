package com.uch.vueproject.model;

import lombok.Data;

@Data
public class GameDetailResponse extends BaseResponse {
    GameDetailEntity data;

    public GameDetailResponse(int code, String message, GameDetailEntity data) {
        super(code, message);

        this.data = data;
    }
}
