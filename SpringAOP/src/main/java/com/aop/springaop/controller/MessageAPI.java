package com.aop.springaop.controller;

import com.aop.springaop.service.MessageService;
import com.aop.springaop.service.SecondMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageAPI {

    private final MessageService messageService;
    private final SecondMessageService secondMessageService;

    @PostMapping
    public ResponseEntity<String> find(@RequestBody String message){
        secondMessageService.message("Second Message Service");
        return ResponseEntity.ok(messageService.sendMessage(message));
    }

}
