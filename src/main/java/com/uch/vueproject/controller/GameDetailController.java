package com.uch.vueproject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uch.vueproject.model.GameDetailEntity;
import com.uch.vueproject.model.GameDetailResponse;

@RestController
public class GameDetailController {
    @RequestMapping(value = "/gameDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GameDetailResponse foodDetail(String id) {
        return getGameDetail(id);
    }

private GameDetailResponse getGameDetail(String id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/gamedb?user=root&password=4581196");

            stmt = conn.createStatement();

            // ToDo: 改query:  select name, category, buy_date, exp_date, quantity  from foods f join food_detail fd where f.food_id = fd.id;
            rs = stmt.executeQuery("select * from game_description where id = '" + id + "'");//這裡是要加入查的資料庫

            boolean isDataExist = rs.next();

            // 如果isDataExist == false代表一筆資料都沒有
            if(!isDataExist) {
                return new GameDetailResponse(2, "無此資料, id=" + id, null);
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

}
