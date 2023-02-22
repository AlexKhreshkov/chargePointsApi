package com.example.chargePointsApi.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "first_name", nullable = true)
    private String first_name;
    @Column(name = "last_name", nullable = true)
    private String last_name;
    @Column(name = "email", nullable = true, unique = true)
    private String email;
    @Column(name = "phone", nullable = false, unique = true, length = 30)
    private String phone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<VehicleEntity> vehicles;

}
