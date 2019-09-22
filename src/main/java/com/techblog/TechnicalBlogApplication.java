package com.techblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@ComponentScan
//@EnableAutoConfiguration
public class TechnicalBlogApplication {

    public static void main(String[] args){
        SpringApplication.run(TechnicalBlogApplication.class, args);
    }

}
