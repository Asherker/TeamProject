package com.uch.vueproject.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ShowRecordListResponse extends BaseResponse {
   ShowRecordListEntity data;

    public ShowRecordListResponse(int code, String message, ArrayList<ShowRecordEntity> shows, int total) {
        super(code, message);

        this.data = new ShowRecordListEntity();
        this.data.shows = shows;
        this.data.total = total;
    }
    
}
