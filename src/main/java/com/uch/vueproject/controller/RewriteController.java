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
public class RewriteController {
    @Autowired
    private MySQLConfigBean mysqlb;

    @RequestMapping(value = "/rewrite", method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse rewrite(@RequestBody RecallEntity data){
    Connection conn = null;
    PreparedStatement stmt =null;
    try{
        Class.forName(mysqlb.getDriverClassName());

        conn = DriverManager.getConnection(mysqlb.getUrl() + mysqlb.getData()+ "?user=" + mysqlb.getUsername() + "&password=" + mysqlb.getKuo());

        stmt = conn.prepareStatement("UPDATE trackinghistory SET name=?, category=?, developer=?, platform=?, price=?, quantity=?, inchange=?, outchange=? WHERE id=?");
        stmt.setString(1, data.getId());
        stmt.setString(2, data.getName());
        stmt.setString(3, data.getPlatform());
        stmt.setString(4, data.getCategory());
        stmt.setString(5, data.getDeveloper());
        stmt.setInt(6, data.getPrice());
        stmt.setInt(7, data.getQuantity());
        stmt.setDate(8, data.getInchange());
        stmt.setDate(9, data.getOutchange());
        stmt.setDate(10, data.getFinalupdate());

        stmt.executeUpdate();

        return new BaseResponse(0, "已新增舊有資料至歷史資料表");
    }catch(SQLException e) {
        return new BaseResponse(e.getErrorCode(), e.getMessage());
    }catch(ClassNotFoundException e) {
        return new BaseResponse(5,"歷史紀錄新增失敗");
    }
    }
        
    
}
