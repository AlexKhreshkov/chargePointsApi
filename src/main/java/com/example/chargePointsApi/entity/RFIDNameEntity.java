package com.example.chargePointsApi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "RFIDName")
public class RFIDNameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "RFIDName")
    private List<RFIDEntity> RFIDs;

}
