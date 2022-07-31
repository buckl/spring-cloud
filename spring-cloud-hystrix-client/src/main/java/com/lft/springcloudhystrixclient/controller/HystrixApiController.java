package com.lft.springcloudhystrixclient.controller;


import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HystrixApiController {
    private final static Random random = new Random();

    @GetMapping("/hello2")
    public String helloWorld() {
        return new MyHystrixCommand().execute();
    }

    public String errorContent() {
        return "Fault";
    }

    /**
     * 编程的方式
     */
    private class MyHystrixCommand extends com.netflix.hystrix.HystrixCommand<String> {

        protected MyHystrixCommand() {
            super(HystrixCommandGroupKey.Factory.asKey("Hello world"), 100);
        }

        @Override
        protected String run() throws Exception {
            int i = random.nextInt(200);
            System.out.printf("helloWorld sleep %s 秒 \n", i);
            Thread.sleep(i);
            return "hello world";
        }

        @Override
        protected String getFallback() {
            return HystrixApiController.this.errorContent();
        }
    }
}
