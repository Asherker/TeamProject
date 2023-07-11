package com.uch.vueproject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uch.vueproject.bean.MySQLConfigBean;
import com.uch.vueproject.model.BaseResponse;
<<<<<<< Updated upstream
import com.uch.vueproject.model.GameDetailResponse;
=======
import com.uch.vueproject.model.GameEntity;
import com.uch.vueproject.model.GameResponse;
>>>>>>> Stashed changes
import com.uch.vueproject.model.RecordEntity;
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
            Class.forName(mysqlb.getDriverClassName());

            conn = DriverManager.getConnection("jdbc:mysql://localhost/gamedb?user=root&password=4581196");

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
        PreparedStatement stmt2 = null;

        try{
            Class.forName(mysqlb.getDriverClassName());
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/gamedb?user=root&password=4581196");

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

    private BaseResponse recordold(GameEntity data){
        Connection conn = null;
        // PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;

        try{
            Class.forName(mysqlb.getDriverClassName());
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/gamedb?user=root&password=4581196");
            stmt2 = conn.createStatement();

            stmt2 = conn.prepareStatement("INSERT INTO trackinghistory VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
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

            return new BaseResponse(0, "已新增至歷史資料表");
            
            }catch(SQLException e) {
                return new BaseResponse(e.getErrorCode(), e.getMessage());
            }catch(ClassNotFoundException e) {
                return new BaseResponse(5,"歷史紀錄新增失敗");
        }
    }
    
}
