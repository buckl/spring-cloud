package com.lft.test.intercepter.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GlobalAopAdvice {

    @Pointcut("execution (* com.lft.test.intercepter.controller..*.*(..))")
    public void test() {

    }

    @Before("test()")
    public void beforeAdvice(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

    }

    @After("test()")
    public void afterAdvice(JoinPoint joinPoint) {

    }
}
