package com.lft.annotation.test;

import com.lft.annotation.bean.User;
import com.lft.annotation.config.Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

public class IOC_Test {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    @Test
    public void test1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

    @Test
    public void test2() {
        String[] beanNamesForType = context.getBeanNamesForType(User.class);
        Environment environment = context.getEnvironment();
        Map<String, User> beansOfType = context.getBeansOfType(User.class);
        beansOfType.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });

    }


}
