package com.example.springmultitenant.repository;

import com.example.springmultitenant.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    City findByName(String name);

    void deleteByName(String name);
}