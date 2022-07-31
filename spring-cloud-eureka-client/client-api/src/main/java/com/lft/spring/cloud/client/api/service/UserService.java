package com.lft.spring.cloud.client.api.service;

import com.lft.spring.cloud.client.api.domain.User;

import java.util.Collection;

public interface UserService {
    boolean save(User user);

    Collection<User> findAll();
}
