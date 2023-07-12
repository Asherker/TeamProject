package com.uch.vueproject.model;

import lombok.Data;

@Data
public class RecordResponse extends BaseResponse {
    ShowRecordEntity data;

    public RecordResponse(int code, String message, ShowRecordEntity data) {
        super(code, message);

        this.data = data;
    }
}
