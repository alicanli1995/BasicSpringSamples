package com.example.hr.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Employee;
import com.example.hr.domain.IdentityNo;
import com.example.hr.dto.request.HireEmployeeRequest;
import com.example.hr.dto.request.IncreaseSalaryRequest;
import com.example.hr.dto.response.EmployeeResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HrService {

	private HrApplication hrApplication;
	// Object 2 Object Mapping
	private ModelMapper modelMapper;

	public HrService(HrApplication hrApplication, ModelMapper modelMapper) {
		this.hrApplication = hrApplication;
		this.modelMapper = modelMapper;
	}

	public Mono<EmployeeResponse> hireEmployee(HireEmployeeRequest request) {
		var employee = modelMapper.map(request, Employee.class);
		return hrApplication.hireEmployee(employee)
				.map(employee1 -> modelMapper.map(employee1, EmployeeResponse.class));

	}

	public Mono<EmployeeResponse> findEmployeeByIdentity(String identityNo) {
		return hrApplication.getEmployeeInformation(IdentityNo.valueOf(identityNo))
				.map(employee -> modelMapper.map(employee, EmployeeResponse.class));

	}

	public Mono<EmployeeResponse> fireEmployee(String identityNo) {
		 return hrApplication.fireEmployee(IdentityNo.valueOf(identityNo))
				.map(employee -> modelMapper.map(employee, EmployeeResponse.class));
	}

	public Flux<EmployeeResponse> updateSalaryInDepartment(IncreaseSalaryRequest request) {
		return hrApplication.increaseSalary(request.getDepartment(),
				                            request.getRate())
				.map(returnedEmployee -> modelMapper.map(returnedEmployee, EmployeeResponse.class));
	}

}
