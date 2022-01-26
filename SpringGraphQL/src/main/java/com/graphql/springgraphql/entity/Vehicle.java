package com.graphql.springgraphql.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "vehicle")
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,name = "vehicle_type")
    private String type;

    @Column(length = 100,name = "model_code")
    private String modelCode;

    @Column(length = 100,name = "brand_name")
    private String brandName;

    @Column(length = 100,name = "launch_date")
    private Date launchDate;


}
