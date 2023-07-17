package com.uch.vueproject.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ShowRecordListEntity {

    ArrayList<ShowRecordEntity> shows;
    int total;
    
}
