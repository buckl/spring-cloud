package com.lft.spring.entity.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class SequenceGenerator {
    @Autowired
    private PrefixGenerator[] prefixGenerators;
    private String prefix;
    private String suffix;
    private int initial;
    private final AtomicInteger counter = new AtomicInteger();
    private PrefixGenerator prefixGenerator;

    @Autowired(required = false)
    public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
        this.prefixGenerator = prefixGenerator;
    }

    @Autowired
    public void myOwnCustomInjectionName(PrefixGenerator prefixGenerator) {
        this.prefixGenerator = prefixGenerator;
    }

    public String getSequence() {
        return prefix +
                initial +
                counter.getAndIncrement() +
                suffix;
    }
}
