package com.example.hr;

import com.example.hr.repository.EmployeeDocumentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class ReactiveHrMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveHrMicroserviceApplication.class, args);
	}

}
