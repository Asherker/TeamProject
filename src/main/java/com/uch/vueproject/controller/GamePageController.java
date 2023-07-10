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
import com.uch.vueproject.model.GameListResponse;

@RestController
@RequestMapping("/list")
public class GamePageController {
    @RequestMapping(value = "/games", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GameListResponse games(int page, int count ,int SortMode) {
        return getProductList(page, count,SortMode);
    }

    private GameListResponse getProductList(int page, int count,int SortMode) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/gamedb?user=root&password=4581196");

            stmt = conn.createStatement();

            // ToDo: 改query
            rs = stmt.executeQuery("select * from gameinfo " + 
            (SortMode == 0 ? "" : (SortMode == 1 ? "order by price ASC":"order by price DESC")) 
                                 + " limit " + count + " offset " + ((page-1) * count));

            ArrayList<GameEntity> games = new ArrayList<>();
            while(rs.next()) {
                GameEntity gameEntity = new GameEntity();
                gameEntity.setId(rs.getString("id"));
                gameEntity.setName(rs.getString("name"));
                gameEntity.setPlatform(rs.getString("platform"));
                gameEntity.setCategory(rs.getString("category"));
                gameEntity.setDeveloper(rs.getString("developer"));
                gameEntity.setQuantity(rs.getInt("quantity"));
                gameEntity.setPrice(rs.getInt("price"));
                gameEntity.setInchange(rs.getDate("inchange"));
                gameEntity.setOutchange(rs.getDate("outchange"));

                games.add(gameEntity);
            }

            // 取得全部數量
            rs = stmt.executeQuery("select count(*) as c from gameinfo");
            rs.next();
            int total = rs.getInt("c");

            return new GameListResponse(0, "成功", games, total);
        } catch(SQLException e) {
            return new GameListResponse(e.getErrorCode(), e.getMessage(), null, 0);
        } catch(ClassNotFoundException e) {
            return new GameListResponse(1, "無法註冊驅動程式", null, 0);
        }
    }

}
