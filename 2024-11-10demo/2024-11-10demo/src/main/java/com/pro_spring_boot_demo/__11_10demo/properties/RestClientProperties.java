package com.pro_spring_boot_demo.__11_10demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("lft")
@Data
public class RestClientProperties {
    private String url;

    private String basePath;

}
