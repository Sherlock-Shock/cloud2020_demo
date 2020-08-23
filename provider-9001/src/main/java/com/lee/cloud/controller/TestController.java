package com.lee.cloud.controller;

import com.lee.cloud.Service.SayHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    SayHello sayHello;

    @GetMapping(value = "/test/{name}")
    public String test(@PathVariable("name") String name){
        return sayHello.sayHello(name);
    }
}
