package com.example.hr.repository;

import java.util.Optional;

import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.hr.domain.IdentityNo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeRepository {

	Mono<Boolean> exists(IdentityNo identity);

	Mono<Employee> createEmployee(Employee employee);

	Mono<Employee> removeEmployee(IdentityNo id);

	Mono<Employee> findEmployeeByIdentityNo(IdentityNo id);

	Flux<Employee> findAllEmployeesByDepartment(Department department);

}
