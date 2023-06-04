package com.lft.test.intercepter.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GlobalAopAdvice {

    @Pointcut("execution (* com.lft.test.intercepter.controller..*.*(..))")
    public void controllerPointcut() {}

    @Before("controllerPointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String paramString = JSONObject.toJSONString(args[0]);
        System.out.println(paramString);
    }
}
