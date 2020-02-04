package com.example.graphql.demo.service;


import static com.google.common.base.Preconditions.checkArgument;

import com.example.graphql.demo.graphql.CreateOwnerInput;
import com.example.graphql.demo.model.Owner;
import com.example.graphql.demo.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OwnerService {

    private final OwnerRepository repository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository){
        this.repository = ownerRepository;
    }

    @Transactional
    public Owner createOwner(CreateOwnerInput input){
        Owner owner = new Owner();
        owner.setFirstName(input.getFirstName());
        owner.setLastName(input.getLastName());
        owner.setCity(input.getCity());
        owner.setPhone(input.getPhone());
        return repository.save(owner);
    }

    @Transactional
    public Owner getOwner(Integer id) {
        return repository.findById(id).get();
    }
}
