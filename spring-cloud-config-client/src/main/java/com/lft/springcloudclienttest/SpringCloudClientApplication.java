package com.lft.springcloudclienttest;

import com.lft.springcloudclienttest.health.MyHealthIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;

@SpringBootApplication
public class SpringCloudClientApplication {

    private final ContextRefresher contextRefresher;

    private final Environment environment;

    @Autowired
    public SpringCloudClientApplication(ContextRefresher contextRefresher, Environment environment) {
        this.contextRefresher = contextRefresher;
        this.environment = environment;
    }

    //    定时刷新server端配置修改后的值（/refresh）
    @Scheduled(fixedRate = 5 * 1000, initialDelay = 2 * 1000)
    public void autoRefresh() {
        Set<String> refreshValues = contextRefresher.refresh();
        refreshValues.forEach(data -> {
            System.err.printf("[线程:%s ], 更新配置项目：key:%s value:%s \n", Thread.currentThread().getName(), data, environment.getProperty(data));
        });

        System.out.printf("[线程:%s ], 更新配置项目：%s \n", Thread.currentThread().getName(), refreshValues);
    }

    @Bean
    public MyHealthIndicator myHealthIndicator() {
        return new MyHealthIndicator();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClientApplication.class, args);
    }

}
