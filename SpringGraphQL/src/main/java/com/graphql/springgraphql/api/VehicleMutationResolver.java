package com.graphql.springgraphql.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.springgraphql.dto.VehicleCreateRequest;
import com.graphql.springgraphql.entity.Vehicle;
import com.graphql.springgraphql.repository.VehicleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleMutationResolver implements GraphQLMutationResolver {

    private final VehicleDto vehicleDto;

    public Vehicle createVehicle(VehicleCreateRequest vehicleCreateRequest){
         return vehicleDto.save(VehicleCreateRequest.convertToEntity(vehicleCreateRequest));
    }
}
