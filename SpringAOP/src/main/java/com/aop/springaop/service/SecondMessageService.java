package com.aop.springaop.service;

import org.springframework.stereotype.Service;

@Service
public class SecondMessageService {

    public void message(String s){
        System.out.println("Method send a message , param : " + s);
    }
}
