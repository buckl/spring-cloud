package com.lft.user.service.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceProviderBootstrapApplication {


    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderBootstrapApplication.class, args);
    }
}
