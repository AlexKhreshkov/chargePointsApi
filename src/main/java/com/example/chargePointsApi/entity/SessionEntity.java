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
    @Column(name="startDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name="endDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(nullable = true)
    private Float duration;
    @CreatedDate
    @Column(nullable = true)
    private Float start_meter;

    @Column(nullable = true)
    private Float end_meter;
    @ManyToOne()
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicle;
    @ManyToOne()
    @JoinColumn(name = "connector_id")
    private ConnectorEntity connector;

    public SessionEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart_date() {
        return startDate;
    }

    public void setStart_date(Date start_date) {
        this.startDate = start_date;
    }

    public Date getEnd_date() {
        return endDate;
    }

    public void setEnd_date(Date end_date) {
        this.endDate = end_date;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public Float getStart_meter() {
        return start_meter;
    }

    public void setStart_meter(Float start_meter) {
        this.start_meter = start_meter;
    }

    public Float getEnd_meter() {
        return end_meter;
    }

    public void setEnd_meter(Float end_meter) {
        this.end_meter = end_meter;
    }

    public VehicleEntity getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleEntity vehicle) {
        this.vehicle = vehicle;
    }

    public ConnectorEntity getConnector() {
        return connector;
    }

    public void setConnector(ConnectorEntity connector) {
        this.connector = connector;
    }
}

