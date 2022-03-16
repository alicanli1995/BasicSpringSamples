package com.example.hr.adapter;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.hr.domain.IdentityNo;
import com.example.hr.repository.EmployeeDocumentRepository;
import com.example.hr.repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.function.Function;

@Service
public class EmployeeRepositorySpringDataMongoAdapter implements EmployeeRepository{

	private final EmployeeDocumentRepository employeeDocumentRepository;
	private final ModelMapper modelMapper;
	private final Function<EmployeeDocument,Employee>
			EMPLOYEE_DOCUMENT_TO_EMPLOYEE_RESPONSE_MAPPER;

	public EmployeeRepositorySpringDataMongoAdapter(EmployeeDocumentRepository employeeDocumentRepository, ModelMapper modelMapper) {
		this.employeeDocumentRepository = employeeDocumentRepository;
		this.modelMapper = modelMapper;
		EMPLOYEE_DOCUMENT_TO_EMPLOYEE_RESPONSE_MAPPER =  doc -> modelMapper.map(doc, Employee.class);
	}

	@Override
	public Mono<Boolean> exists(IdentityNo identity) {
		return employeeDocumentRepository.existsById(identity.getValue());
	}

	@Override
	public Mono<Employee> createEmployee(Employee employee) {
		var document = modelMapper.map(employee, EmployeeDocument.class);
		return employeeDocumentRepository.insert(document)
				.map(EMPLOYEE_DOCUMENT_TO_EMPLOYEE_RESPONSE_MAPPER);
	}

	@Override
	public Mono<Employee> removeEmployee(IdentityNo id) {
		return employeeDocumentRepository.findById(id.getValue())
				.publishOn(Schedulers.boundedElastic())
				.doOnNext(cust -> employeeDocumentRepository.delete(cust).subscribe(System.out::println))
				.map(EMPLOYEE_DOCUMENT_TO_EMPLOYEE_RESPONSE_MAPPER);
	}


	@Override
	public Mono<Employee> findEmployeeByIdentityNo(IdentityNo id) {
		return employeeDocumentRepository.findById(id.getValue())
				.map(EMPLOYEE_DOCUMENT_TO_EMPLOYEE_RESPONSE_MAPPER);

	}

	@Override
	public Flux<Employee> findAllEmployeesByDepartment(Department department) {
		return employeeDocumentRepository.findAllByDepartment(department)
				.map(document -> modelMapper.map(document, Employee.class));
	}
	
}
