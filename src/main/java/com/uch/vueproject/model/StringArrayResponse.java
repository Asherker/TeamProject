package com.uch.vueproject.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class StringArrayResponse extends BaseResponse {
    ArrayList<String> data;

    public StringArrayResponse(int code, String message, ArrayList<String> data) {
        super(code, message);

        this.data = data;
    }
}
