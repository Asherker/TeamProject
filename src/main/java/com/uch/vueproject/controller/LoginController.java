package com.uch.vueproject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uch.vueproject.bean.MySQLConfigBean;
import com.uch.vueproject.model.LoginResponse;

import jakarta.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private MySQLConfigBean mysqlb;

    @RequestMapping(value="/login", method = RequestMethod.GET,produces = "application/json")
    public LoginResponse login(String username,String password, HttpSession httpSession) {
        LoginResponse response = checkAccount(username, password);

        if(response.getCode() == 0) {// 登入成功
            httpSession.setAttribute("loginStatus", username + "已登入");
        } else 
            httpSession.removeAttribute("loginStatus");  // 清除登入狀態

        return response;

    }
        private LoginResponse checkAccount(String username, String password) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        //註冊mySQL資料庫驅動程式
        try {
            Class.forName(mysqlb.getDriverClassName());
            //連線資料庫
            conn = DriverManager.getConnection(mysqlb.getUrl() + mysqlb.getData()+ "?user=" + mysqlb.getUsername() + "&password=" + mysqlb.getPassword());
            //取得Statement物件
            stmt = conn.createStatement();
            //查詢該帳號是否存在
            rs = stmt.executeQuery("select count(*) as c from account where name='" + username + "'");
            //判斷帳號是否存在
            rs.next();//跳到查詢結果的第一筆資料
            int c = rs.getInt("c");//查詢到的資料筆數
            //帳號不存在的話，返還錯誤
            if (c == 0) {
            rs.close();
            stmt.close();
            conn.close();

            return new LoginResponse(2,"帳號不存在");
            }
            //帳號存在則繼續判斷密碼
            rs = stmt.executeQuery("select count(*) as c from account "+
            "where name='" + username + "' and password='" + password + "';");

            //移動第一筆資料
            rs.next();
            c = rs.getInt("c");//查詢到的資料筆數

            rs.close();
            stmt.close();
            conn.close();

            //密碼錯誤
            if (c == 0) {
                return new LoginResponse(3,"密碼錯誤");
            }
            return new LoginResponse(0,"登入成功");
            
        }catch (ClassNotFoundException e){
            //無法註冊(錯誤代碼1)
            return new LoginResponse(1, "無法註冊驅動程式");
        }catch(SQLException e) {
            return new LoginResponse(e.getErrorCode(),e.getMessage());
        }
    }
}
