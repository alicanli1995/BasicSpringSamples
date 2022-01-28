package com.exceptionhandling.springexceptionhandling.service;


import com.exceptionhandling.springexceptionhandling.entity.Car;
import com.exceptionhandling.springexceptionhandling.exception.NotFoundCarException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private static final List<Car> carList = new ArrayList<>();

    @PostConstruct
    public void init(){
        carList.add(new Car("Test Car - A", "001"));
        carList.add(new Car("Test Car - B", "002"));
        carList.add(new Car("Test Car - C", "003"));
        carList.add(new Car("Test Car - D", "004"));
    }

    public Car getCar(String name) {
        if(name.startsWith("1")){
            throw new IllegalArgumentException();
        }
        return  carList.stream()
                .filter(car -> car.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NotFoundCarException(name));
    }
}
