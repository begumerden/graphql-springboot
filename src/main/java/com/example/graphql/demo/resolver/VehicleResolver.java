package com.example.graphql.demo.resolver;


import static com.google.common.base.Preconditions.checkArgument;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.demo.model.Vehicle;
import org.springframework.stereotype.Component;

/**
 * Since the Vehicle class does not have fullname  field,
 * we must provide a resolver for the Vehicle type that returns this information
 */
@Component
public class VehicleResolver implements GraphQLResolver<Vehicle> {

    public String fullName(final Vehicle vehicle) {
        checkArgument(vehicle != null);
        return vehicle.getModelCode() + " " + vehicle.getBrandName();
    }
}
