package com.example.hr.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.hr.application.business.event.EmployeeEvent;
import com.example.hr.infra.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class EventPublisherKafkaTemplateAdapter implements EventPublisher {
	private final String hrEventTopic;
	private final KafkaTemplate<String, String> kafkaTemplate;
	private final ObjectMapper objectMapper;
	

	public EventPublisherKafkaTemplateAdapter(@Value("${hr.event.topic}") String hrEventTopic,
			KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
		this.hrEventTopic = hrEventTopic;
		this.kafkaTemplate = kafkaTemplate;
		this.objectMapper = objectMapper;
	}

	@Override
	public void publish(EmployeeEvent employeeEvent) {
		try {
			var employeeEventAsJson = objectMapper.writeValueAsString(employeeEvent);
			kafkaTemplate.send(hrEventTopic, employeeEventAsJson);
		} catch (JsonProcessingException e) {
			System.err.println(e.getMessage());
		}

	}

}
