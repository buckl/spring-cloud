package com.lft.spring.config;

import com.lft.spring.entity.impl.PrefixGenerator;
import org.springframework.context.annotation.Bean;

public class PrefixConfiguration {
    @Bean("prefixGenerator")
    public PrefixGenerator productSequenceGenerator() {
        PrefixGenerator sequence = new PrefixGenerator();
        return sequence;
    }
}
