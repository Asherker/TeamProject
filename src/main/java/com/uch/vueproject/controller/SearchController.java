package com.uch.vueproject.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uch.vueproject.model.SearchEntity;
import com.uch.vueproject.model.SearchListResponse;


@RestController
@RequestMapping("/tracking")
public class SearchController extends BaseController {
    @RequestMapping(value = "/record", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public SearchListResponse searchGame(String[] column, String keyword, String keyvalue, int page, int count, int sortMode) {
        
        return search(column, keyword, keyvalue, page, count, sortMode);
    }

    private SearchListResponse search(String[] column, String keyword, String keyvalue, int page, int count, int sortMode){

        try {
            // 連線資料料庫
            connect(mysqlb.getUrl());
            stmt = conn.createStatement();

            String whereToken = "";
            for(int i = 0 ; i < column.length ; i++) {
                whereToken += column[i] + " like '%" + keyword + "%'";

                if(i != column.length - 1) whereToken += " or ";
            }

            String queryString = "select id,gameid,user,movement,updatetime from trackinghistory " +
            " where " + whereToken + (sortMode == 0 ? "order by id DESC" : (sortMode == 1 ? "order by gameid DESC":"order by gameid ASC") )
             + " limit " + count + " offset " + ((page-1) * count);

            System.out.println(queryString);

            rs = stmt.executeQuery(queryString);

            ArrayList<SearchEntity> shows = new ArrayList<>();
            while(rs.next()) {
                SearchEntity searchEntity = new SearchEntity();
                searchEntity.setId(rs.getInt("id"));
                searchEntity.setGameid(rs.getString("gameid"));
                searchEntity.setUser(rs.getString("user"));
                searchEntity.setMovement(rs.getString("movement"));
                searchEntity.setUpdatetime(rs.getDate("updatetime"));
            
                shows.add(searchEntity);
            }

            // 取得全部數量
            rs = stmt.executeQuery("select count(*) as c from trackinghistory where " + whereToken);
            rs.next();
            int total = rs.getInt("c");

            return new SearchListResponse(0, "搜尋成功", shows, total);
        } catch (ClassNotFoundException e) {
            return new SearchListResponse(1, "找不到驅動程式", null, 0);
        } catch (SQLException e) {
            return new SearchListResponse(e.getErrorCode(), e.getMessage(), null, 0);
        } 

    }

    
}
