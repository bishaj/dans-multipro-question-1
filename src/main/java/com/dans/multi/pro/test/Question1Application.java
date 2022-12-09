package com.dans.multi.pro.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Question1Application {

    public static void main(String[] args) {
        SpringApplication.run(Question1Application.class, args);
    }

}
