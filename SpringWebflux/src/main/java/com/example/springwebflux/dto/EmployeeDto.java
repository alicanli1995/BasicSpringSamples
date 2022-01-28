package com.example.springwebflux.dto;

import com.example.springwebflux.entity.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeDto extends ReactiveMongoRepository<Employee,String> {
}
