package com.uch.vueproject.model;

import java.sql.Date;

import lombok.Data;

@Data
public class RecordEntity {
    int id;
    String gameid;
    String user;
    String movement;
    Date updateTime;
    
}
