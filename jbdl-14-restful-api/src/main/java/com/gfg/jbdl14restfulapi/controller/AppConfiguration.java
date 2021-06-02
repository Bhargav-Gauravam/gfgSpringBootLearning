package com.gfg.jbdl14restfulapi.controller;

import ch.qos.logback.core.db.DriverManagerConnectionSource;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfiguration {

    @Bean
    Map<String, Movie> movies(){
        return new ConcurrentHashMap<>();
    }

    // JDBC connection
    @Bean
    DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource
                = new DriverManagerDataSource();
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/movie");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return driverManagerDataSource;
    }

    // this is a template object
    // we will need these template objects to connect to reddis and kafka as well
    @Bean
    JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
}
