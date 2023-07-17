package com.uch.vueproject.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class SearchListResponse extends BaseResponse {

    SearchListEntity data;

    public SearchListResponse(int code, String message, ArrayList<SearchEntity> shows, int total) {
        super(code, message);

        this.data = new SearchListEntity();
        this.data.shows = shows;
        this.data.total = total;
    }
    
}
