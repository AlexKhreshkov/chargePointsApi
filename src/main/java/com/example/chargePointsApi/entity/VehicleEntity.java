package com.example.chargePointsApi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vehicle")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle")
    private List<RFIDEntity> RFIDs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle")
    private List<SessionEntity> sessions;

}
