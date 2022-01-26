package com.graphql.springgraphql.repository;

import com.graphql.springgraphql.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleDto extends JpaRepository<Vehicle,Long> {

    List<Vehicle> getByTypeLike(String vehicleType);

}
