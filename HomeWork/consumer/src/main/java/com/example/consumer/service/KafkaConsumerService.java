package com.example.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	
	@KafkaListener(topics = "hr-events", groupId = "market")
	public void listenMessage(String order) {
		System.err.println(order);
	}
}
