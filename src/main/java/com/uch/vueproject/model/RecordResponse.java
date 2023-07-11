package com.uch.vueproject.model;

import lombok.Data;

@Data
public class RecordResponse extends BaseResponse {
    RecordEntity data;

    public RecordResponse(int code, String message, RecordEntity data) {
        super(code, message);

        this.data = data;
    }
}
