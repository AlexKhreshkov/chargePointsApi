package com.example.chargePointsApi.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "session")
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date start_date;
    @Temporal(TemporalType.TIMESTAMP)
    private Date end_date;
    private Float duration;
    @CreatedDate
    @Column(nullable = false)
    private Float start_meter;
    private Float end_meter;
    @ManyToOne()
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicle;
    @ManyToOne()
    @JoinColumn(name = "connector_id")
    private ConnectorEntity connector;
}
