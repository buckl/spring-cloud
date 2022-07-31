package com.lft.user.service.provider.service;

import com.lft.spring.cloud.client.api.domain.User;
import com.lft.spring.cloud.client.api.service.UserService;
import com.lft.user.service.provider.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;



    @Override
    public boolean save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }
}
