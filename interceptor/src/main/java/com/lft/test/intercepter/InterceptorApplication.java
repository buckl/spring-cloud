package com.lft.test.intercepter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class InterceptorApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterceptorApplication.class, args);
		log.error("this is a new program");
	}

}
