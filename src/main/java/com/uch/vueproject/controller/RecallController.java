package com.uch.vueproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.uch.vueproject.bean.MySQLConfigBean;
import com.uch.vueproject.model.BaseResponse;
import com.uch.vueproject.model.RecallEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@RestController
public class RecallController {
    @Autowired
    private MySQLConfigBean mysqlb;

    @RequestMapping(value = "/recall", method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse recall(@RequestBody RecallEntity data){
    Connection conn = null;
    PreparedStatement stmt =null;
    
    try{
        Class.forName(mysqlb.getDriverClassName());
            
        conn = DriverManager.getConnection(mysqlb.getUrl() + mysqlb.getData()+ "?user=" + mysqlb.getUsername() + "&password=" + mysqlb.getKuo());

        stmt = conn.prepareStatement("INSERT INTO recall VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, data.getId());
        stmt.setString(2, data.getName());
        stmt.setString(3, data.getGamename());
        stmt.setString(4, data.getPlatform());
        stmt.setString(5, data.getCategory());
        stmt.setString(6, data.getDeveloper());
        stmt.setInt(7, data.getPrice());
        stmt.setInt(8, data.getQuantity());
        stmt.setDate(9, data.getInchange());
        stmt.setDate(10, data.getOutchange());
        stmt.setDate(11, data.getFinalupdate());

        stmt.executeUpdate();

        return new BaseResponse(0, "回溯功能資料新增成功");
            
        }catch(SQLException e) {
            return new BaseResponse(e.getErrorCode(), e.getMessage() + "," + mysqlb.getUrl() + mysqlb.getData()+ "?user=" + mysqlb.getUsername() + "&password=maxkuo625");
        }catch(ClassNotFoundException e) {
            return new BaseResponse(9,"回溯功能新增失敗");
        }
    }
}
