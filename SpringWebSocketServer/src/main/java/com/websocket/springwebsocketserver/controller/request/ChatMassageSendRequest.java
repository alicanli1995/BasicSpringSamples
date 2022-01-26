package com.websocket.springwebsocketserver.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class ChatMassageSendRequest implements Serializable {
    private String sender;
    private String message;
}
