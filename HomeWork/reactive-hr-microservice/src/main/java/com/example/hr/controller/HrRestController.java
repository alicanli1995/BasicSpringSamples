package com.example.hr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.hr.dto.request.HireEmployeeRequest;
import com.example.hr.dto.request.IncreaseSalaryRequest;
import com.example.hr.dto.response.EmployeeResponse;
import com.example.hr.service.HrService;
import com.example.hr.validation.TcKimlikNo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("employees")
@Validated
@CrossOrigin
// Adapter -> HTTP Protocol <- mapping -> Java Class Methods
public class HrRestController {
	private final Logger logger = LoggerFactory.getLogger(HrRestController.class);

	private HrService hrService;
	
	public HrRestController(HrService hrService) {
		this.hrService = hrService;
	}

	// GET http://localhost:8100/hr/api/v1/employees/11111111110
	@GetMapping("{identityNo}")
	public Mono<EmployeeResponse> getEmployeeInfo(
			@PathVariable @TcKimlikNo String identityNo) {
		return hrService.findEmployeeByIdentity(identityNo);
	}
	
	@PostMapping
	public Mono<EmployeeResponse> hireEmployee(@RequestBody @Validated HireEmployeeRequest request) {
		return hrService.hireEmployee(request);
	}

	@DeleteMapping("{identityNo}")
	public Mono<EmployeeResponse> fireEmployee(
			@PathVariable @TcKimlikNo String identityNo) {
		return hrService.fireEmployee(identityNo);
	}

	@PutMapping
	public Flux<EmployeeResponse> increaseSalary(
			@RequestBody @Validated IncreaseSalaryRequest request) {
		return hrService.updateSalaryInDepartment(request);
	}
}
