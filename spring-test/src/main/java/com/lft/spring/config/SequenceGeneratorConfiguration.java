package com.lft.spring.config;

import com.lft.spring.entity.impl.PrefixGenerator;
import com.lft.spring.entity.impl.SequenceGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PrefixConfiguration.class)
public class SequenceGeneratorConfiguration {
    @Value("#{prefixGenerator}")
    private PrefixGenerator prefixGenerator;

    @Bean
    public SequenceGenerator sequenceGenerator() {
        SequenceGenerator generator = new SequenceGenerator();
        generator.setPrefix("30");
        generator.setSuffix("A");
        generator.setInitial(100000);
        generator.setPrefixGenerator(prefixGenerator);
        return generator;
    }


}