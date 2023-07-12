package com.uch.vueproject.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ShowRecordResponse extends BaseResponse{
    ArrayList<ShowRecordEntity> data;

    public ShowRecordResponse(int code,String message,ArrayList<ShowRecordEntity> data) {
        super(code,message);
        this.data =data;

    }
}