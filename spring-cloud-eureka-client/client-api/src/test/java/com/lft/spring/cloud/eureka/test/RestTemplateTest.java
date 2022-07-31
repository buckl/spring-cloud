package com.lft.spring.cloud.eureka.test;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RestTemplateTest {

    public static void main(String[] args) {
//        RestTemplate template = new RestTemplate();
        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        Map map = template.getForObject("http://localhost:8080/env", Map.class);
        String str = template.getForObject("http://localhost:8080/env", String.class);

    }
}
