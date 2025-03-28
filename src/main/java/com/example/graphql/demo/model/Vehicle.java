package com.example.graphql.demo.model;

import com.example.graphql.demo.graphql.VehicleType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
@Entity
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "type", nullable = false)
    private VehicleType type;
    @Column(name = "model_code", nullable = false)
    private String modelCode;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "launch_date")
    private LocalDate launchDate;
    private transient  String formattedDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @EqualsAndHashCode.Exclude
    private Owner owner;

}
