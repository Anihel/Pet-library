package com.an.library.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/testGet")
    public String testGet() {
        return "testGet";
    }
}
