package com.lft.spring.cloud.feign.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaTestFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaTestFeignApplication.class, args);
	}

}
