package com.rabbitmq.rabbitmq.listiner;

import com.rabbitmq.rabbitmq.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "test-rabbit-queue")
    public void onMessage(Notification notification){
        System.out.println("Received queue ... ");
        System.out.println(notification.toString());
    }
}
