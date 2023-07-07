package com.uch.vueproject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uch.vueproject.model.BaseResponse;
import com.uch.vueproject.model.GameEntity;
import com.uch.vueproject.model.GameResponse;

@RestController
public class GameController {
    @RequestMapping(value = "/games", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GameResponse games(){
        return getGameList();
    }

    @RequestMapping(value = "/games", method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,  // 傳入的資料格式
        produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public GameResponse addGame(@RequestBody GameEntity data) {
        return new GameResponse(999, data.toString(), null);
    }
    @RequestMapping(value = "/updategames", method = RequestMethod.PUT,
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse updateGame(@RequestBody GameEntity data){
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/gamedb?user=root&password=maxkuo625");

            stmt = conn.prepareStatement("UPDATE gameinfo SET name=?, category=?, developer=?, price=?, quantity=?, inchange=?, outchange=? where id=?");
            stmt.setString(1, data.getName());
            stmt.setString(2, data.getCategory());
            stmt.setString(3, data.getDeveloper());
            stmt.setInt(4, data.getPrice());
            stmt.setInt(5, data.getQuantity());
            stmt.setDate(6, data.getInchange());
            stmt.setDate(7, data.getOutchange());
            stmt.setString(8, data.getId());

            stmt.executeUpdate();

            return new BaseResponse(9, "資料更新成功");
        }catch(SQLException e){
            return new BaseResponse(e.getErrorCode(), e.getMessage());
        }catch(ClassNotFoundException e){
            return new BaseResponse(99, "無法註冊驅動程式");
        }
    }
    
    private GameResponse getGameList() {
=======
    public BaseResponse addGame(@RequestBody GameEntity data) {
>>>>>>> a2255aff878539f2ac7429242f53b47f19d5dbe6
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
<<<<<<< HEAD
            conn = DriverManager.getConnection("jdbc:mysql://localhost/gamedb?user=root&password=maxkuo625");
=======
            conn = DriverManager.getConnection("jdbc:mysql://localhost/gamedb?user=root&password=4581196");

            
            stmt = conn.prepareStatement("INSERT INTO gameinfo VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, data.getName());
            stmt.setString(2, data.getPlatform());
            stmt.setString(3, data.getCategory());
            stmt.setString(4, data.getDeveloper());
            stmt.setInt(5, data.getPrice());
            stmt.setInt(6, data.getQuantity());
            stmt.setDate(7, data.getInchange());
            stmt.setDate(8, data.getOutchange());

            stmt.executeUpdate();

            return new BaseResponse(0, "新增成功");
        }catch(SQLException e) {
            return new BaseResponse(e.getErrorCode(), e.getMessage());
        }catch(ClassNotFoundException e) {
            return new BaseResponse(1,"無法註冊驅動程式");
        }
    }


        private GameResponse getGameList() {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/gamedb?user=root&password=4581196");
>>>>>>> a2255aff878539f2ac7429242f53b47f19d5dbe6
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from gameinfo");//這裡後續要修改資料庫路徑以及要修改的項目

            ArrayList<GameEntity> games = new ArrayList<>();
            while(rs.next()){
                GameEntity gameEntity = new GameEntity();
                gameEntity.setId(rs.getString("id"));
                gameEntity.setName(rs.getString("name"));
                gameEntity.setCategory(rs.getString("category"));
                gameEntity.setPrice(rs.getInt("price"));
                gameEntity.setQuantity(rs.getInt("quantity"));
                gameEntity.setDeveloper(rs.getString("developer"));
                gameEntity.setInchange(rs.getDate("inchange"));
                gameEntity.setOutchange(rs.getDate("outchange"));
                gameEntity.setPlatform(rs.getString("platform"));
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
