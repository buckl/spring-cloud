package com.lft.spring.cloud.feign.api.service;


import com.lft.spring.cloud.feign.api.domain.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

/**
 * {@link Person}
 */
@FeignClient(value = "person-service")
public interface PersonService {

    @PostMapping("/person/save")
    boolean save(@RequestBody Person person);

    @GetMapping("/person/find/all")
    Collection<Person> findAll();
}
