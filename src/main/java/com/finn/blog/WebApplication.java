package com.finn.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
 * @description: 启动类
 * @author: Finn
 * @create: 2022/04/03 18:08
 */
@MapperScan("com.finn.blog.dao")
@SpringBootApplication
@EnableScheduling
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}

