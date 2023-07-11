package com.uch.vueproject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uch.vueproject.model.BaseResponse;
import com.uch.vueproject.model.GameDetailResponse;
import com.uch.vueproject.model.RecordEntity;
import com.uch.vueproject.model.RecordResponse;

@RestController
public class RecordController {

    @RequestMapping(value = "/record", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse recordEntity(@RequestBody RecordEntity data) {
        return record(data);
    }

    @RequestMapping(value = "/showrecord", method = RequestMethod.GET,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public RecordResponse Record(@RequestBody RecordEntity data) {
        return showRecord(data);
    }

    public RecordResponse showRecord(RecordEntity data){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/gamedb?user=root&password=maxkuo625");

            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM trackinghistory ORDER BY updatetime DESC");

            boolean isDataExist = rs.next();

            if(!isDataExist){
                return new RecordResponse(0, "無此資料, name=" + data, null);
            }else{
                RecordEntity recordentity = new RecordEntity();
                recordentity.setId(rs.getInt("id"));
                recordentity.setName(rs.getString("name"));
                recordentity.setMovement(rs.getString("movement"));
                recordentity.setUpdateTime(rs.getDate("updatetime"));

                return new RecordResponse(0, "成功", recordentity);
            }
        }catch(SQLException e) {
            return new RecordResponse(e.getErrorCode(), e.getMessage(), null);
        } catch(ClassNotFoundException e) {
            return new RecordResponse(1, "歷史紀錄抓取失敗", null);
        }

    }

    private BaseResponse record(RecordEntity data){
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/gamedb?user=root&password=maxkuo625");
            
            stmt = conn.prepareStatement("INSERT INTO trackinghistory VALUES(?, ?, ?, ?)");
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
