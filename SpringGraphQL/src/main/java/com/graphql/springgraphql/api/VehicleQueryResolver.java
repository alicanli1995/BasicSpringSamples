package com.graphql.springgraphql.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.springgraphql.entity.Vehicle;
import com.graphql.springgraphql.repository.VehicleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleQueryResolver implements GraphQLQueryResolver {

    private final VehicleDto vehicleDto;

    public List<Vehicle> getVehiclesByName(String vehicleType){
        return vehicleDto.getByTypeLike(vehicleType);
    }


    public Optional<Vehicle> getVehiclesById(Long id){
            return vehicleDto.findById(id);
    }

}
