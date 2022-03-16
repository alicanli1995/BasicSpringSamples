package com.example.hr.application;

import java.util.List;
import java.util.Optional;

import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.hr.domain.IdentityNo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HrApplication {
	Mono<Employee> hireEmployee(Employee employee);

	Mono<Employee> fireEmployee(IdentityNo id);

	Mono<Employee> getEmployeeInformation(IdentityNo id);

	Flux<Employee> increaseSalary(Department department, double rate);
}
