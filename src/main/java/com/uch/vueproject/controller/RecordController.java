package com.uch.vueproject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uch.vueproject.model.BaseResponse;
import com.uch.vueproject.model.RecordEntity;

@RestController
public class RecordController {

    @RequestMapping(value = "/record", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse recordEntity(@RequestBody RecordEntity data) {
        return record(data);
    }

    private BaseResponse record(RecordEntity data){
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/gamedb?user=root&password=maxkuo625");

            stmt = conn.prepareStatement("INSERT INTO trackinghisoty VALUES(?, ?, ?, ?)");
            stmt.setInt(1, data.getId());
            stmt.setString(2, data.getName());
            stmt.setString(3, data.getMovement());
            stmt.setDate(4, data.getUpdateTime());

            stmt.executeUpdate();

            return new BaseResponse(0, "已新增至歷史資料表");
            
            }catch(SQLException e) {
                return new BaseResponse(e.getErrorCode(), e.getMessage());
            }catch(ClassNotFoundException e) {
                return new BaseResponse(5,"歷史紀錄新增失敗");
        }
    }
    
}
