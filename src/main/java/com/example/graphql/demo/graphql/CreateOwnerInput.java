package com.example.graphql.demo.graphql;

import lombok.Data;

@Data
public class CreateOwnerInput {

    private String firstName;
    private String lastName;
    private String city;
    private String phone;
}
