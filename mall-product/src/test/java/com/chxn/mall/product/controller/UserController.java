package com.chxn.mall.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private static class User{
        int id;
        String name;
        private User(int id, String name){
            this.id = id;
            this.name = name;
        }
    }
    @GetMapping(value={"/user/{id}"})
    public User findUserById(@PathVariable Integer id) {
        /*15*/         logger.info("id: {}", (Object)id);
        /*17*/         if (id != null && id < 1) {
            throw new IllegalArgumentException("id < 1");
        }
        return new User(id.intValue(), "name" + id);
    }

}
