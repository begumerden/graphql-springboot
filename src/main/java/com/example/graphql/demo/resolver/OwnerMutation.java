package com.example.graphql.demo.resolver;


import static com.google.common.base.Preconditions.checkArgument;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.demo.graphql.CreateOwnerInput;
import com.example.graphql.demo.model.Owner;
import com.example.graphql.demo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OwnerMutation implements GraphQLMutationResolver {

    private final OwnerService ownerService;

    @Autowired
    public OwnerMutation(OwnerService ownerService){
        this.ownerService = ownerService;
    }

    public Owner createOwner(CreateOwnerInput input){
        checkArgument(input != null);
        return ownerService.createOwner(input);
    }
}
