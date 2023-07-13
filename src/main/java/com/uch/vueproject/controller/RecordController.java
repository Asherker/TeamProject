package com.uch.vueproject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uch.vueproject.bean.MySQLConfigBean;
import com.uch.vueproject.model.BaseResponse;
import com.uch.vueproject.model.GameEntity;
import com.uch.vueproject.model.GameResponse;

import com.uch.vueproject.model.RecordEntity;
import com.uch.vueproject.model.ShowRecordEntity;
import com.uch.vueproject.model.ShowRecordResponse;
import com.uch.vueproject.model.RecordResponse;

@RestController
public class RecordController {
    @Autowired
    private MySQLConfigBean mysqlb;

    @RequestMapping(value = "/record", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse recordEntity(@RequestBody RecordEntity data) {
        return record(data);
    }

    @RequestMapping(value = "/showrecord", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)

    public ShowRecordResponse showRecord(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            Class.forName(mysqlb.getDriverClassName());
            conn = DriverManager.getConnection(mysqlb.getUrl() + mysqlb.getData()+ "?user=" + mysqlb.getUsername() + "&password=" + mysqlb.getPassword());
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from trackinghistory ORDER BY updatetime" );//這裡後續要修改資料庫路徑以及要修改的項目

            ArrayList<ShowRecordEntity> show = new ArrayList<>();
            while(rs.next()){
                ShowRecordEntity showEntity = new ShowRecordEntity();
                showEntity.setId(rs.getInt("id"));
                showEntity.setGameid(rs.getString("gameid"));
                showEntity.setUser(rs.getString("user"));
                showEntity.setMovement(rs.getString("movement"));
                showEntity.setUpdateTime(rs.getDate("updatetime"));

                show.add(showEntity);
            }
            return new ShowRecordResponse(0,"歷史資料抓取成功",show);
        }catch(SQLException e) {
            return new ShowRecordResponse(e.getErrorCode(), e.getMessage(), null);
        }catch(ClassNotFoundException e) {
            return new ShowRecordResponse(1,"歷史資料抓取失敗",null);
        }

    }

    private BaseResponse record(RecordEntity data){
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            Class.forName(mysqlb.getDriverClassName());
            
            conn = DriverManager.getConnection(mysqlb.getUrl() + mysqlb.getData()+ "?user=" + mysqlb.getUsername() + "&password=" + mysqlb.getPassword());

            stmt = conn.prepareStatement("INSERT INTO trackinghistory VALUES(?, ?, ?, ?, ?)");
            stmt.setInt(1,data.getId());
            stmt.setString(2, data.getGameid());
            stmt.setString(3, data.getUser());
            stmt.setString(4, data.getMovement());
            stmt.setDate(5, data.getUpdatetime());

            stmt.executeUpdate();

            return new BaseResponse(0, "已新增至歷史資料表");
            
            }catch(SQLException e) {
                return new BaseResponse(e.getErrorCode(), e.getMessage());
            }catch(ClassNotFoundException e) {
                return new BaseResponse(5,"歷史紀錄新增失敗");
        }
    }
    
}
