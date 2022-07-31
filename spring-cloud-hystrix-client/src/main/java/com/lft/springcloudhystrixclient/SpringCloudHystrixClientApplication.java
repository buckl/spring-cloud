package com.lft.springcloudhystrixclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @EnableHystrix 激活Hystrix，没有spring cloud的内容
 * @EnableCircuitBreaker 激活熔断保护 包含@EnableHystrix
 */
@SpringBootApplication
//@EnableHystrix
@EnableCircuitBreaker
public class SpringCloudHystrixClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudHystrixClientApplication.class, args);
    }

}
