package com.lft.spring.cloud.feign.client;

import com.lft.spring.cloud.feign.api.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 当@EnableEurekaClient 注释掉后，使用ribbon的方式
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = {PersonService.class})
@EnableHystrix
public class PersonClientApplicationBootStrap {
    public static void main(String[] args) {
        SpringApplication.run(PersonClientApplicationBootStrap.class, args);
    }
}
