package com.example.springwebflux;

import com.example.springwebflux.dto.EmployeeDto;
import com.example.springwebflux.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringWebfluxApplication {

    private final EmployeeDto employeeDto;

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void appStart(){
        if(employeeDto.count().block() == 0 ){
            IntStream.range(0,100)
                    .mapToObj(this::generate)
                    .map(employeeDto::save)
                    .collect(Collectors.toList())
                    .forEach(o -> o.subscribe
                            (System.out::println,
                                    System.err::println));
        }
    }

    private Employee generate(int i){
        return Employee.builder()
                .name("Name " + i)
                .lastName("LastName " + i)
                .birthDate(LocalDate.now())
                .build();
    }

}
