package com.example.springmultitenant.controller;


import com.example.springmultitenant.entity.City;
import com.example.springmultitenant.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping(value = "/createcity")
    public ResponseEntity<?> save(@RequestBody @Validated CityCreateRequestDTO city) {

        cityService.save(City.builder()
                        .name(city.getName())
                        .tenantId(city.getTenantId())
                .build());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/getcity/all")
    public ResponseEntity<List<City>> getAll() throws SQLException {
        List<City> cities = cityService.getAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping(value = "/getcity/{id}")
    public ResponseEntity<City> get(@PathVariable(value = "id") Long id) {
        City city = cityService.get(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping(value = "/getcitybyname/{name}")
    public ResponseEntity<City> get(@PathVariable(value = "name") String name) {
        City city = cityService.getByName(name);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @DeleteMapping(value = "deletebyname/{name}")
    public ResponseEntity<City> delete(@PathVariable(value = "name") String name) {
        cityService.delete(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
