package com.example.jackson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 启动类
 *
 * @author xiaoxuxuy
 */
@SpringBootApplication
public class JackJsonApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JackJsonApplication.class, args);
    }

}
