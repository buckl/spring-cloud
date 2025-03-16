package com.lft.spring.config;

import com.lft.spring.entity.Product;
import com.lft.spring.entity.impl.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:discounts.properties")
public class ShopConfiguration {

    @Value("classpath:banner.txt")
    private Resource banner;

    @Bean
    public BannerLoader banner() {
        BannerLoader b = new BannerLoader();
        b.setBanner(banner);
        return b;
    }


    @Value("${endofyear.discount:0.5}")
    private double discount;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Product dvdrw() {
        Disc p2 = new Disc("DVD-RW", discount);
        p2.setCapacity(600);
        return p2;
    }

    @Bean()
    public DatePrefixGenerator datePrefixGenerator() {
        DatePrefixGenerator dpg = new DatePrefixGenerator();
        dpg.setPattern("yyyyMMdd");
        return dpg;
    }

    @Bean()
    public PrefixGenerator productSequenceGenerator() {
        PrefixGenerator sequence = new PrefixGenerator();
        return sequence;
    }

    @Bean
    public SequenceGenerator sequenceGenerator() {
        SequenceGenerator sequence = new SequenceGenerator();
        sequence.setInitial(100000);
        sequence.setSuffix("A");
        return sequence;
    }


    @Bean
    public Product aaa() {
        Battery p1 = new Battery("AAA", 2.5);
        p1.setRechargeable(true);
        return p1;
    }

    @Bean
    public Product cdrw() {
        Disc p2 = new Disc("CD-RW", 1.5);
        p2.setCapacity(700);
        return p2;
    }
}