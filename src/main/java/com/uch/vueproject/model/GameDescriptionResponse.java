package com.uch.vueproject.model;

import lombok.Data;

@Data
public class GameDescriptionResponse extends BaseResponse{
    gameDescriptionEntity data;
        public GameDescriptionResponse(int code,String message,gameDescriptionEntity data) {
            super(code, message);
            this.data = data;
        }
}