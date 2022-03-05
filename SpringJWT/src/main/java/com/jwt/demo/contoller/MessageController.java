package com.jwt.demo.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @GetMapping
    public String sayHello(){
        return "Hello world";
    }

}
