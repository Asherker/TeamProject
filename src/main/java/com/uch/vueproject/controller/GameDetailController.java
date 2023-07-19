package com.uch.vueproject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uch.vueproject.bean.MySQLConfigBean;
import com.uch.vueproject.model.GameDetailEntity;
import com.uch.vueproject.model.GameDetailResponse;

@RestController
public class GameDetailController {
    @Autowired
    private MySQLConfigBean mysqlb;

    @RequestMapping(value = "/gameDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GameDetailResponse gamesDetail(String value) {
        return getGameDetail(value);
    }

    private GameDetailResponse getGameDetail(String value) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName(mysqlb.getDriverClassName());

            conn = DriverManager.getConnection(mysqlb.getUrl() + mysqlb.getData()+ "?user=" + mysqlb.getUsername() + "&password=" + mysqlb.getPassword());

            stmt = conn.createStatement();

            // ToDo: 改query:  select name, category, buy_date, exp_date, quantity  from foods f join food_detail fd where f.food_id = fd.id;
            rs = stmt.executeQuery("select * from game_description where ch_name = '" +  value + "'");//這裡是要加入查的資料庫

            boolean isDataExist = rs.next();

            // 如果isDataExist == false代表一筆資料都沒有
            if(!isDataExist) {
                return new GameDetailResponse(2, "無此資料, name=" + value, null);
            } else {
                GameDetailEntity gameDetailEntity = new GameDetailEntity();
                gameDetailEntity.setId(rs.getString("id"));
                gameDetailEntity.setChname(rs.getString("ch_name"));
                gameDetailEntity.setEnname(rs.getString("en_name"));
                gameDetailEntity.setDevyear(rs.getInt("dev_yaer"));
                gameDetailEntity.setDescription(rs.getString("description"));


                return new GameDetailResponse(0, "成功", gameDetailEntity);
            }

        } catch(SQLException e) {
            return new GameDetailResponse(e.getErrorCode(), e.getMessage(), null);
        } catch(ClassNotFoundException e) {
            return new GameDetailResponse(1, "無法註冊驅動程式", null);
        }
    }

    @RequestMapping(value = "/adddescribe", method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,  // 傳入的資料格式
        produces = MediaType.APPLICATION_JSON_VALUE)
    public GameDetailResponse adddescribe(@RequestBody GameDetailEntity data) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try{
            Class.forName(mysqlb.getDriverClassName());
            conn = DriverManager.getConnection(mysqlb.getUrl() + mysqlb.getData()+ "?user=" + mysqlb.getUsername() + "&password=" + mysqlb.getPassword());
        
            stmt = conn.prepareStatement("INSERT INTO game_description VALUES(?, ?, ?, ?, ?)");
            stmt.setString(1, data.getId());
            stmt.setString(2, data.getChname());
            stmt.setString(3, data.getEnname());
            stmt.setInt(4, data.getDevyear());
            stmt.setString(5, data.getDescription());
            

            stmt.executeUpdate();

            return new GameDetailResponse(0, "資料新增成功", data);

        }catch(SQLException e) {
            return new GameDetailResponse(e.getErrorCode(), e.getMessage(), data);
        }catch(ClassNotFoundException e) {
            return new GameDetailResponse(9,"資料新增失敗", data);
        }
    }

}
