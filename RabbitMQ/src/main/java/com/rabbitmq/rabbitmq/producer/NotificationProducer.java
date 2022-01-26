package com.rabbitmq.rabbitmq.producer;

import com.rabbitmq.rabbitmq.model.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationProducer {

    @Value("${sr.rabbit.routing.name}")
    private String bindingKey;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @PostConstruct
    public void init(){
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreatedDate(new Date());
        notification.setMessage("Test Queue With RabbitMQ");
        notification.setSeen(Boolean.FALSE);
        sendToQueue(notification);

    }

    private final RabbitTemplate rabbitTemplate;

    public void sendToQueue(Notification notification){
        System.out.println("Notification sending id : " + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName,bindingKey,notification);
    }

}
