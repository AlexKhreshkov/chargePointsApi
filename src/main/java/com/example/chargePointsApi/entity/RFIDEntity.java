package com.example.chargePointsApi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "RFID")
public class RFIDEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "RFID_name_id")
    private RFIDNameEntity RFIDName;

    @ManyToOne()
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicle;
}
