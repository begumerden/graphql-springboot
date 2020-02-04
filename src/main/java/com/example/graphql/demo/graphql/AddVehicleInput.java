package com.example.graphql.demo.graphql;

import lombok.Data;

@Data
public class AddVehicleInput {

    private Integer ownerId;
    private String type;
    private String modelCode;
    private String brandName;
    private String launchDate;
}
