package com.dockerization.dockerization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class ApiController {

    @GetMapping
    public String sendMessage(){
        return "Hello in the docker images...";
    }

}
