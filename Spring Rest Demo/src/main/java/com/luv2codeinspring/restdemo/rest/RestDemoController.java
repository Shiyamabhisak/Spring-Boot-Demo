package com.luv2codeinspring.restdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestDemoController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World";
    }
}
