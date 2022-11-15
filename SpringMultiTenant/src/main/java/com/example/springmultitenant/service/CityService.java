package com.example.springmultitenant.service;

import com.example.springmultitenant.entity.City;
import com.example.springmultitenant.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {


    private final CityRepository cityRepository;

    public void save(City city) {
        cityRepository.save(city);
    }

    public List<City> getAll() throws SQLException {
        return cityRepository.findAll();

    }

    public City get(Long id) {
        return cityRepository.findById(id).orElseThrow(
                () -> new RuntimeException("City not found with id: " + id)
        );
    }

    public City getByName(String name) {
        return cityRepository.findByName(name);
    }

    public void delete(String name) {
        cityRepository.deleteByName(name);
    }
}