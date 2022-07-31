package com.lft.spring.cloud.client.service.consumer.controller;

import com.lft.spring.cloud.client.api.domain.User;
import com.lft.spring.cloud.client.api.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserRestApiController {

    private final UserService userService;

    public UserRestApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/save")
    public User saveUser(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        if (userService.save(user)) {
            return user;
        } else {
            return null;
        }
    }

    @GetMapping("/user/list")
    public Collection<User> list() {
        return userService.findAll();
    }
}
