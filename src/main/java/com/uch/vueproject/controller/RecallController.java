package com.uch.vueproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.uch.vueproject.bean.MySQLConfigBean;
import com.uch.vueproject.model.BaseResponse;
import com.uch.vueproject.model.GameEntity;

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
    public BaseResponse recall(@RequestBody GameEntity data){
    Connection conn = null;
    PreparedStatement stmt2 = null;
    try{
        Class.forName(mysqlb.getDriverClassName());
            
        conn = DriverManager.getConnection(mysqlb.getUrl() + mysqlb.getData()+ "?user=" + mysqlb.getUsername() + "&password=" + mysqlb.getPassword());

        stmt2 = conn.prepareStatement("INSERT INTO trackinghistory VALUES(?, null, null, null, ?, ?, ?, ?, ?, ?, ?, ?)");
        stmt2.setString(1, data.getId());
        stmt2.setString(2, data.getName());
        stmt2.setString(3, data.getPlatform());
        stmt2.setString(4, data.getCategory());
        stmt2.setString(5, data.getDeveloper());
        stmt2.setInt(6, data.getPrice());
        stmt2.setInt(7, data.getQuantity());
        stmt2.setDate(8, data.getInchange());
        stmt2.setDate(9, data.getOutchange());

        stmt2.executeUpdate();

        return new BaseResponse(0, "已新增舊有資料至歷史資料表");
            
        }catch(SQLException e) {
            return new BaseResponse(e.getErrorCode(), e.getMessage());
        }catch(ClassNotFoundException e) {
            return new BaseResponse(5,"歷史紀錄新增失敗");
        }
    }
    @RequestMapping(value = "/rewrite", method = RequestMethod.PUT,
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse rewrite(@RequestBody GameEntity data){
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            Class.forName(mysqlb.getDriverClassName());
            conn = DriverManager.getConnection(mysqlb.getUrl() + mysqlb.getData()+ "?user=" + mysqlb.getUsername() + "&password=" + mysqlb.getPassword());

            stmt = conn.prepareStatement("UPDATE gameinfo SET name=?, category=?, developer=?, platform=?, price=?, quantity=?, inchange=?, outchange=? WHERE id=?");
            stmt.setString(1, data.getName());
            stmt.setString(2, data.getCategory());
            stmt.setString(3, data.getDeveloper());
            stmt.setString(4, data.getPlatform());
            stmt.setInt(5, data.getPrice());
            stmt.setInt(6, data.getQuantity());
            stmt.setDate(7, data.getInchange());
            stmt.setDate(8, data.getOutchange());
            stmt.setString(9, data.getId());

            stmt.executeUpdate();

            return new BaseResponse(0, "資料更新成功");
        }catch(SQLException e){
            return new BaseResponse(e.getErrorCode(), e.getMessage());
        }catch(ClassNotFoundException e){
            return new BaseResponse(4, "資料更新失敗");
        }
    }
}
