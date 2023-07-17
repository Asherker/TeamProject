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
@RequestMapping("/v1")
public class SearchController extends BaseController {
    @RequestMapping(value = "/record/{columnName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public SearchListResponse searchGame(@PathVariable String columnName, String keyword, String keyvalue, int page, int count, int SortMode) {
        return search(columnName, keyword, keyvalue, page, count, SortMode);
    }

    private SearchListResponse search(String columnName, String keyword, String keyvalue, int page, int count, int SortMode){

        try {
            // 連線資料料庫
            connect(mysqlb.getUrl());
            stmt = conn.createStatement();

            String queryString = "select gameid, user,updatetime from trackinghistory" + (SortMode == 0 ? "" : (SortMode == 1 ? "order by price ASC":"order by price DESC") ) + 
            " where " + columnName + " like '%" + keyword + "%'" + " limit " + count + " offset " + ((page-1) * count);

            if(keyvalue.length() == 0) {
                queryString = "select gameid, user,updatetime from trackinghistory" + (SortMode == 0 ? "" : (SortMode == 1 ? "order by price ASC":"order by price DESC") ) + 
                    " where " + columnName + " like '%" + keyword + "%'" + " limit " + count + " offset " + ((page-1) * count);
            } else {
                // 數字搜尋
                queryString = "select gameid, user,updatetime from trackinghistory"+ (SortMode == 0 ? "" : (SortMode == 1 ? "order by price ASC":"order by price DESC") ) + 
                    " where " + columnName + " = " + keyvalue + " limit " + count + " offset " + ((page-1) * count);
            }

            rs = stmt.executeQuery(queryString);

            ArrayList<SearchEntity> shows = new ArrayList<>();
            while(rs.next()) {
                SearchEntity searchEntity = new SearchEntity();
                searchEntity.setGameid(rs.getString("gameid"));
                searchEntity.setUser(rs.getString("user"));
                searchEntity.setUpdatetime(rs.getDate("updatetime"));
            
                shows.add(searchEntity);
            }

            // 取得全部數量
            rs = stmt.executeQuery("select count(*) as c from trackinghistory where " + columnName + " like '%" + keyword + "%'");
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
