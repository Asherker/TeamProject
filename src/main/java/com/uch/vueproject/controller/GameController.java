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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uch.vueproject.bean.MySQLConfigBean;
import com.uch.vueproject.model.BaseResponse;
import com.uch.vueproject.model.GameEntity;
import com.uch.vueproject.model.GameResponse;
import com.uch.vueproject.model.StringArrayResponse;

@RestController
public class GameController {
    @Autowired
    private MySQLConfigBean mysqlb;

    @RequestMapping(value = "/games", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GameResponse games() {
        return getGameList();
    }


    //資料新增
    @RequestMapping(value = "/gameInList", method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,  // 傳入的資料格式
        produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse addGame(@RequestBody GameEntity data) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try{
            Class.forName(mysqlb.getDriverClassName());
            conn = DriverManager.getConnection(mysqlb.getUrl() + mysqlb.getData()+ "?user=" + mysqlb.getUsername() + "&password=" + mysqlb.getPassword());
        
            stmt = conn.prepareStatement("INSERT INTO gameinfo VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, data.getId());
            stmt.setString(2, data.getName());
            stmt.setString(3, data.getPlatform());
            stmt.setString(4, data.getCategory());
            stmt.setString(5, data.getDeveloper());
            stmt.setInt(6, data.getPrice());
            stmt.setInt(7, data.getQuantity());
            stmt.setDate(8, data.getInchange());
            stmt.setDate(9, data.getOutchange());

            stmt.executeUpdate();

            return new BaseResponse(0, "資料新增成功");

        }catch(SQLException e) {
            return new BaseResponse(e.getErrorCode(), e.getMessage());
        }catch(ClassNotFoundException e) {
            return new BaseResponse(5,"資料新增失敗");
        }
    }

    //資料修改
    @RequestMapping(value = "/updategames", method = RequestMethod.PUT,
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse updateGame(@RequestBody GameEntity data){
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            Class.forName(mysqlb.getDriverClassName());
            conn = DriverManager.getConnection(mysqlb.getUrl() + mysqlb.getData()+ "?user=" + mysqlb.getUsername() + "&password=" + mysqlb.getPassword());

            stmt = conn.prepareStatement("UPDATE gameinfo SET name=?, category=?, developer=?, platform=?, price=?, quantity=?, inchange=?, outchange=? WHERE id=?");
            stmt.setString(1, data.getName());
            stmt.setString(2, data.getCategory());
            stmt.setString(3, data.getDeveloper());
            stmt.setString(4, data.getPlatform());
            stmt.setInt(5, data.getPrice());
            stmt.setInt(6, data.getQuantity());
            stmt.setDate(7, data.getInchange());
            stmt.setDate(8, data.getOutchange());
            stmt.setString(9, data.getId());

            stmt.executeUpdate();

            return new BaseResponse(0, "資料更新成功");
        }catch(SQLException e){
            return new BaseResponse(e.getErrorCode(), e.getMessage());
        }catch(ClassNotFoundException e){
            return new BaseResponse(4, "資料更新失敗");
        }
    }

    //資料刪除
     @RequestMapping(value = "/delgames", method = RequestMethod.DELETE,
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse DelGame(@RequestBody GameEntity data){
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            Class.forName(mysqlb.getDriverClassName());
            conn = DriverManager.getConnection(mysqlb.getUrl() + mysqlb.getData()+ "?user=" + mysqlb.getUsername() + "&password=" + mysqlb.getPassword());

            stmt = conn.prepareStatement("DELETE FROM gameinfo where id=?");
            stmt.setString(1, data.getId());

            stmt.executeUpdate();

            return new BaseResponse(0, "資料刪除成功");
        }catch(SQLException e){
            return new BaseResponse(e.getErrorCode(), e.getMessage());
        }catch(ClassNotFoundException e){
            return new BaseResponse(3, "資料刪除失敗");
        }
    }

        //資料搜尋
        @RequestMapping(value = "/gamesearch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public StringArrayResponse getGameName(String keyword){
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try{
                Class.forName(mysqlb.getDriverClassName());

                conn = DriverManager.getConnection(mysqlb.getUrl() + mysqlb.getData()+ "?user=" + mysqlb.getUsername() + "&password=" + mysqlb.getPassword());
                stmt = conn.createStatement();

                rs = stmt.executeQuery("select name from gameinfo where name like '%" + keyword + "%'");

            ArrayList<String> data = new ArrayList<>();
            while(rs.next()){
                data.add(rs.getString("name"));
            }

            return new StringArrayResponse(0, "搜尋成功", data);
            }catch(SQLException e){
                return new StringArrayResponse(e.getErrorCode(), e.getMessage(), null);
            }catch(ClassNotFoundException e){
                return new StringArrayResponse(2, "搜尋失敗", null);
            }
        }

    
    

        private GameResponse getGameList() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            Class.forName(mysqlb.getDriverClassName());
            conn = DriverManager.getConnection(mysqlb.getUrl() + mysqlb.getData()+ "?user=" + mysqlb.getUsername() + "&password=" + mysqlb.getPassword());
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from gameinfo" );//這裡後續要修改資料庫路徑以及要修改的項目

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
