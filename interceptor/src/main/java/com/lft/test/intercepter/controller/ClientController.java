package com.lft.test.intercepter.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientController {

    @GetMapping("/first/request")
    public String firstRequest(@RequestBody Param param) {
        return "hello world";
    }

    @Data
    public static class Param {
        private String name;
        private int age;
        private String msg;
    }

}
