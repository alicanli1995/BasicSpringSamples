package com.exceptionhandling.springexceptionhandling.controller;


import com.exceptionhandling.springexceptionhandling.entity.Car;
import com.exceptionhandling.springexceptionhandling.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<Car> getCar(@RequestParam String name){
        return ResponseEntity.ok(carService.getCar(name));
    }


}
