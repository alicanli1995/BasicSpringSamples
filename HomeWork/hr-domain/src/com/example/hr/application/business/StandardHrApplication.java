package com.example.hr.application.business;

import com.example.hr.application.HrApplication;
import com.example.hr.application.business.event.EmployeeFiredEvent;
import com.example.hr.application.business.event.EmployeeHiredEvent;
import com.example.hr.application.business.event.SalaryChangedEvent;
import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.hr.domain.IdentityNo;
import com.example.hr.infra.EventPublisher;
import com.example.hr.repository.EmployeeRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class StandardHrApplication implements HrApplication {
	private EmployeeRepository employeeRepository;
	private EventPublisher eventPublisher;

	public StandardHrApplication(EmployeeRepository employeeRepository, EventPublisher eventPublisher) {
		this.employeeRepository = employeeRepository;
		this.eventPublisher = eventPublisher;
	}
	@Override
	public Mono<Employee> hireEmployee(Employee employee) {
		return employeeRepository.createEmployee(employee)
				.doOnNext(employeeEvent -> eventPublisher.publish(new EmployeeHiredEvent(employee.getIdentity())));
	}

	@Override
	public Mono<Employee> fireEmployee(IdentityNo id) {
		return employeeRepository.findEmployeeByIdentityNo(id)
				.doOnNext(employee -> employeeRepository.removeEmployee(employee.getIdentity()).subscribe(System.out::println))
				.doOnNext(employeeEvent -> eventPublisher.publish(new EmployeeFiredEvent(employeeEvent)));
	}

	@Override
	public Mono<Employee> getEmployeeInformation(IdentityNo id) {
		return employeeRepository.findEmployeeByIdentityNo(id);
	}

	@Override
	public Flux<Employee> increaseSalary(Department department, double rate) {
		return employeeRepository.findAllEmployeesByDepartment(department)
				.map(employee -> {
					employee.setSalary(employee.getSalary().multiply(1.0 + rate));
					eventPublisher.publish(new SalaryChangedEvent(employee));
					return employee;
				});
	}

}
