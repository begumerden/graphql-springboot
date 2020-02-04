package com.example.graphql.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.demo.model.Owner;
import com.example.graphql.demo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OwnerQuery implements GraphQLQueryResolver {
    private final OwnerService ownerService;

    @Autowired
    public OwnerQuery(OwnerService ownerService){
        this.ownerService = ownerService;
    }

    public Owner getOwner(Integer id){
        return ownerService.getOwner(id);
    }

}
