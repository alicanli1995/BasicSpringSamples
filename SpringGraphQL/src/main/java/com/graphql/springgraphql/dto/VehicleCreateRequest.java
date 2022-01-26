package com.graphql.springgraphql.dto;

import com.graphql.springgraphql.entity.Vehicle;
import lombok.Data;

import java.util.Date;


@Data
public class VehicleCreateRequest {
    private String type;
    private String modelCode;
    private String brandName;

    public static Vehicle convertToEntity(VehicleCreateRequest vehicleCreateRequest){
        Vehicle vehicle = new Vehicle();
        vehicle.setType(vehicleCreateRequest.getType());
        vehicle.setBrandName(vehicleCreateRequest.getBrandName());
        vehicle.setModelCode(vehicleCreateRequest.getModelCode());
        vehicle.setLaunchDate(new Date());
        return vehicle;
    }
}
