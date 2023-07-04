package com.uch.vueproject;

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

import com.uch.vueproject.model.ProductEntity;
import com.uch.vueproject.model.ProductResponse;

@RestController
public class ProductController {
    //API入口
    @RequestMapping(value="/SystemManagment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse Product() {
        return getProductList();
    }

        private ProductResponse getProductList(){
        Connection conn =null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //連接資料庫(!!這裡之後要修改成專案的資料庫!!)
            conn = DriverManager.getConnection("jdbc:mysql://localhost/demo?user=root&password=4581196");

            //取得Statement
            stmt = conn.createStatement();

            //查詢全部商品
            rs = stmt.executeQuery("select * from product");
            //建立陣列存放所有商品用
            ArrayList<ProductEntity> products = new ArrayList<>();
            //將每一筆商品資料讀出來存放到ArrayList內
            while(rs.next()) {
                ProductEntity productEntity = new ProductEntity();
                productEntity.setId(rs.getInt("ID"));
                productEntity.setName(rs.getString("name"));
                productEntity.setDescription(rs.getString("description"));
                productEntity.setPrice(rs.getInt("price"));
                productEntity.setImageUrl(rs.getString("image_url"));
                productEntity.setStoreName(rs.getString("store_name"));
                productEntity.setCategory(rs.getString("category"));
                //將取的商品資料存在ArrayList
                products.add(productEntity);
            }
            rs.close();
            stmt.close();
            conn.close();

            return new ProductResponse(0,"success",products);

        }catch(ClassNotFoundException e) {
            //無法註冊
            return new ProductResponse(1,"無法註冊",null);
        }catch(SQLException e) {
            return new ProductResponse(e.getErrorCode(),e.getMessage(),null);
        }
    }
}
