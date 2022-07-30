package com.lft.annotation.config;

import com.lft.annotation.bean.Color;
import com.lft.annotation.bean.ColorFactoryBean;
import com.lft.annotation.bean.User;
import com.lft.annotation.condition.LftSelect;
import com.lft.annotation.condition.LinuxCondition;
import com.lft.annotation.condition.WindowCondition;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;


/**
 * @Configuration 表示该类是一个配置类
 * @ComponentScan 表示该类具有扫描组件的功能
 * excludeFilters   排除
 * includeFilters 只包含
 */
@Import({Color.class, LftSelect.class})
@Configuration
@ComponentScan(value = "com.lft.annotation", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})})
public class Config {
    //    往容器中注入bean 方法名称就是Bean的ID

    /**
     * SCOPE_PROTOTYPE,多实例
     * SCOPE_SINGLETON,单实力
     * SCOPE_REQUEST, 同一次request 同一个对象
     * SCOPE_SESSION, 同一个session 同一个对象
     */
    @Scope
    @Lazy
    @Bean(value = "user2")
    public User user1() {
        return new User("test", 20);
    }


    @Bean("ma_ke_si")
    @Conditional(LinuxCondition.class)
    public User userConditional() {
        return new User("ma ke si", 59);
    }

    /**
     * @Conditional(value) 按照一定的条件进行判断，满足条件boolean给容器中注册Bean
     * value 是一个实现了org.springframework.context.annotation.Condition的class
     */
    @Conditional(WindowCondition.class)
    @Bean("bill")
    public User userConditional2() {
        return new User("bill gates", 59);
    }


    /**
     * 这个地方注册的类型是FactoryBean，但是实际上注册的是Color类型的
     * 要获取FactoryBean，需要&colorFactoryBean
     *
     * @return
     */

    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }

}

