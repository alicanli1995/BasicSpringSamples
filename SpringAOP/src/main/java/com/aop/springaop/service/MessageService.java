package com.aop.springaop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String sendMessage(String s){
        System.out.println("Method send a message , param : " + s);
        return s;
    }
}
