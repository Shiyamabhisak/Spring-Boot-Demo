package com.luv2codeinspring.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoolController {
    // expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    // expose a new endpoint for "cool"
    @GetMapping("/cool")
    public String sayCool() {
        return "You are so Awesome and Cool !!!";
    }

    @GetMapping("/hot")
    public String sayHot() {
        return "The Climate is too HOT Damn ..... !!!";
    }
}
