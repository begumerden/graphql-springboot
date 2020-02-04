package com.example.graphql.demo.service;


import static com.google.common.base.Preconditions.checkArgument;

import com.example.graphql.demo.model.Owner;
import com.example.graphql.demo.model.Vehicle;
import com.example.graphql.demo.graphql.VehicleType;
import com.example.graphql.demo.repository.OwnerRepository;
import com.example.graphql.demo.repository.VehicleRepository;
import com.example.graphql.demo.graphql.AddVehicleInput;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final OwnerRepository ownerRepository;

    public VehicleService(final VehicleRepository vehicleRepository,
        final OwnerRepository ownerRepository) {
        this.vehicleRepository = vehicleRepository;
        this.ownerRepository = ownerRepository;
    }

    @Transactional
    public Vehicle addVehicle(AddVehicleInput input) {
        final Optional<Owner> optionalOwner = ownerRepository.findById(input.getOwnerId());

        if (!optionalOwner.isPresent()) {
            return new Vehicle();
        }
        Owner owner = optionalOwner.get();
        final Vehicle vehicle = new Vehicle();
        vehicle.setType(VehicleType.valueOf(input.getType()));
        vehicle.setModelCode(input.getModelCode());
        vehicle.setBrandName(input.getBrandName());
        vehicle.setLaunchDate(LocalDate.parse(input.getLaunchDate()));
        vehicle.setOwner(owner);
        owner.getVehicles().add(vehicle);

        return vehicleRepository.save(vehicle);
    }

    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicles(final int count) {
        return this.vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional
    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public boolean deleteVehicle(final int id) {
        try {
            this.vehicleRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}