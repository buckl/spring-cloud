package com.lft.spring.cloud.feign.api.hystrix;

import com.lft.spring.cloud.feign.api.domain.Person;
import com.lft.spring.cloud.feign.api.service.PersonService;
import org.springframework.cloud.netflix.feign.FeignClient;

import java.util.Collection;
import java.util.Collections;

@FeignClient(value = "person-service", fallback = PersonServiceFallBack.class)
public class PersonServiceFallBack implements PersonService {
    @Override
    public boolean save(Person person) {
        return false;
    }

    @Override
    public Collection<Person> findAll() {
        return Collections.emptyList();
    }
}
