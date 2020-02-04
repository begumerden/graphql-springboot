package com.example.graphql.demo.resolver;

import static com.google.common.base.Preconditions.checkArgument;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.demo.model.Vehicle;
import com.example.graphql.demo.graphql.AddVehicleInput;
import com.example.graphql.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleMutation implements GraphQLMutationResolver {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleMutation(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    public Vehicle addVehicle(AddVehicleInput input) {
        checkArgument(input != null);

        return this.vehicleService.addVehicle(input);
    }

    public boolean deleteVehicle(final int id){
        return this.vehicleService.deleteVehicle(id);
    }

}
