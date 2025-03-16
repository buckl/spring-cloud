package com.pro_spring_boot_demo.__11_10demo;

import com.pro_spring_boot_demo.__11_10demo.alth.Count;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    @Value("${spring.application.name}")
    String value1;
    @Bean
    CommandLineRunner values(){
        return args -> {
            System.out.println(value1);
        };
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext();
//	1、
        SpringApplication.run(Application.class, args);
//	2、
//		SpringApplication app = new SpringApplication(Application.class);
//		app.setBanner((a,b,c)->{
//			c.printf("this is my own banner");
//		});
//		app.run(args);
//	3、
//        Logger logger = LoggerFactory.getLogger(Application.class);
//        new SpringApplicationBuilder(Application.class)
//                .listeners(event -> logger.info("### this is ".concat(event.getClass().getCanonicalName())))
//                .run(args);
//        4、
//        new SpringApplicationBuilder(Application.class).web(WebApplicationType.NONE).run(args);
    }

}
