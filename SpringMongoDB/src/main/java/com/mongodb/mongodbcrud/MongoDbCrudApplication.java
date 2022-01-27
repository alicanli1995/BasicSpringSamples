package com.mongodb.mongodbcrud;

import com.mongodb.mongodbcrud.Repo.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoDbCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbCrudApplication.class, args);

	}

}
