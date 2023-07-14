package com.uch.vueproject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import com.uch.vueproject.bean.MySQLConfigBean;


public class BaseController {
    @Autowired
    protected MySQLConfigBean mysqlb;

    protected Connection conn = null;
    protected Statement stmt = null;
    protected ResultSet rs = null;

    protected void connect(String connectionString) throws ClassNotFoundException, SQLException{
        Class.forName(mysqlb.getDriverClassName());

        conn = DriverManager.getConnection(mysqlb.getUrl() + mysqlb.getData()+ "?user=" + mysqlb.getUsername() + "&password=" + mysqlb.getKuo());
    }

    
}
