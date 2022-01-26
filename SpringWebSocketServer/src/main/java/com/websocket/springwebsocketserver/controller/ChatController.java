package com.websocket.springwebsocketserver.controller;

import com.websocket.springwebsocketserver.controller.request.ChatMassageSendRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
//    @SendTo("/topic")
//    @SendToUser()
    public void chatSendMessage(@Payload ChatMassageSendRequest chatMassageSendRequest){
        System.out.println(chatMassageSendRequest);
        simpMessagingTemplate.convertAndSend("/topic",chatMassageSendRequest);

    }

}
