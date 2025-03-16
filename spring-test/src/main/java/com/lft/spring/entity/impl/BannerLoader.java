package com.lft.spring.entity.impl;

import lombok.Data;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

@Data
public class BannerLoader {
    private Resource banner;
    @PostConstruct
    public void init() throws IOException {
        InputStream in = banner.getInputStream();
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(in));
        while (true) {
            String line = reader.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }
        reader.close();
    }
}
