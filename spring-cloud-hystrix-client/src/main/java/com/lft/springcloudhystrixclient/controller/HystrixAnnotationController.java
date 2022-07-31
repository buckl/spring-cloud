package com.lft.springcloudhystrixclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HystrixAnnotationController {
    private final static Random random = new Random();

    /**
     * {@link #helloWorld()}  fallback {@link #errorContent()}
     * 通过注解的方式
     *
     * @return
     */
    @GetMapping("/hello")
    @HystrixCommand(fallbackMethod = "errorContent",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")})
    public String helloWorld() throws Exception {
        int i = random.nextInt(200);
        System.out.printf("helloWorld sleep %s 秒 \n", i);
        Thread.sleep(i);
        return "hello world";
    }


    public String errorContent() {
        return "Fault";
    }

}
