package com.pro_spring_boot_demo.__11_10demo.client;

import com.pro_spring_boot_demo.__11_10demo.handler.ErrorHandler;
import com.pro_spring_boot_demo.__11_10demo.properties.RestClientProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class RestClient {

    private RestTemplate restTemplate;
    private RestClientProperties restClientProperties;

    public RestClient(RestClientProperties restClientProperties) {
        this.restTemplate = new RestTemplate();
        this.restTemplate.setErrorHandler(new ErrorHandler());
        this.restClientProperties = restClientProperties;
    }
}
