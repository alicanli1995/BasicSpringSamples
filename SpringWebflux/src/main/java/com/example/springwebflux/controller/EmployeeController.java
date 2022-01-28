package com.example.springwebflux.controller;


import com.example.springwebflux.dto.EmployeeDto;
import com.example.springwebflux.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeDto employeeDto;

    @GetMapping("/{id}")
    public Mono<Employee> getEmployee(@PathVariable String id){
        return employeeDto.findById(id);
    }

    @GetMapping
    public Flux<Employee> getAllEmployee(){
        return employeeDto.findAll();
    }

}

