package com.example.springworld.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello/{username:.+}")
    public String index(@PathVariable String username){
        return String.format("Hello %s",username);
    }
}
