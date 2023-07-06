package com.uch.vueproject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uch.vueproject.model.GameEntity;
import com.uch.vueproject.model.GameResponse;

@RestController
public class GameController {
    @RequestMapping(value = "/games", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GameResponse games() {
        return getGameList();
    }

    private GameResponse getGameList() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/projectdata?user=root&password=4581196");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from storesystem");//這裡後續要修改資料庫路徑以及要修改的項目

            ArrayList<GameEntity> games = new ArrayList<>();
            while(rs.next()){
                GameEntity gameEntity = new GameEntity();
                gameEntity.setId(rs.getInt("id"));
                gameEntity.setName(rs.getString("name"));
                gameEntity.setCategory(rs.getString("category"));
                gameEntity.setPrice(rs.getInt("price"));
                gameEntity.setQuantity(rs.getInt("quantity"));
                gameEntity.setDeveloper(rs.getString("developer"));
                gameEntity.setInchange(rs.getDate("inchange"));
                gameEntity.setOutchange(rs.getDate("outchange"));

                games.add(gameEntity);
            }
            return new GameResponse(0,"成功",games);
        }catch(SQLException e) {
            return new GameResponse(e.getErrorCode(), e.getMessage(), null);
        }catch(ClassNotFoundException e) {
            return new GameResponse(1,"無法註冊驅動程式",null);
        }
    }
}
