package com.example.chargePointsApi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "connector")
public class ConnectorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "boolean default true")
    private Boolean is_available;
    @ManyToOne()
    @JoinColumn(name = "charge_point_sn")
    private ChargePointEntity chargePoint;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "connector")
    private List<SessionEntity> sessions;

}
