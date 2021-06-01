package com.gfg.jbdl14restfulapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    Map<String, Movie> movies(){
        return new ConcurrentHashMap<>();
    }
}
