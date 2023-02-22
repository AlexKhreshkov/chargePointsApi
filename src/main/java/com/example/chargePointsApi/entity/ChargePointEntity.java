package com.example.chargePointsApi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chargePoint")
public class ChargePointEntity {
    @Id
    @Column(nullable = false, unique = true)
    private String serial_number;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Float capacity;
    @Column(nullable = false)
    private Float rest_power_amount;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private Boolean is_available;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chargePoint")
    private List<ConnectorEntity> connectors;

}
