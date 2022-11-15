package com.example.springmultitenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.springmultitenant.*"})
public class SpringMultiTenantApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMultiTenantApplication.class, args);
    }

}
