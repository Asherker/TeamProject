package com.uch.vueproject.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class MySQLConfigBean {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.searchurl}")
    private String searchurl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.password.kuo}")
    private String kuo;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.database}")
    private String data;
}
