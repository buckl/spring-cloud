package com.lft.spring.cloud.feign.service.Controller;

import com.lft.spring.cloud.feign.api.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 可以实现或不实现{@link com.lft.spring.cloud.feign.api.service.PersonService}
 */
@RestController
public class PersonServiceProviderController {

    private final Map<Long, Person> map = new ConcurrentHashMap<>();

    @PostMapping("/person/save")
    public boolean save(@RequestBody Person person) {
        return map.put(person.getId(), person) == null;
    }


    @GetMapping("/person/find/all")
    public Collection<Person> findAll() {
        return map.values();
    }

}
