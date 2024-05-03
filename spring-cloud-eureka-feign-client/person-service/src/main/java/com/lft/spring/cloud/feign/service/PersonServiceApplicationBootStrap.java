package com.lft.spring.cloud.feign.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PersonServiceApplicationBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApplicationBootStrap.class,args);
    }
}
