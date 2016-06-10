package com.mmt;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Configuration
public class DBConfig {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;
    
    @Value("${spring.datasource.username}")
    private String datasourceUserName;
    
    @Value("${spring.datasource.password}")
    private String datasourcePassword;
    
    @Value("${spring.datasource.driver-class-name}")
    private String datasourceDriver;

    @Bean
    public DataSource setSellerDataSource() { 
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName(datasourceDriver);
        dataSource.setUrl(datasourceUrl);
        dataSource.setUsername(datasourceUserName);
        dataSource.setPassword(datasourcePassword);
        dataSource.setValidationQuery("select 1");
        dataSource.setTestOnBorrow(true);
        dataSource.setValidationInterval(34000);
        return dataSource;
    }

    @Bean
    public JdbcTemplate setJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(setSellerDataSource());
        return jdbcTemplate;
    }

    @Bean
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(setSellerDataSource());
        return namedParameterJdbcTemplate;
    }

//    @Bean
//    public Gson getGson() {
//        GsonBuilder builder = new GsonBuilder();
//        final Gson gson = builder.create();
//        return gson;
//    }
    
    
}
