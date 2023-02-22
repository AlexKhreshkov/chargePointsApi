package com.example.chargePointsApi.repository;

import com.example.chargePointsApi.entity.SessionEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface SessionRepository extends CrudRepository<SessionEntity, Long> {
    SessionEntity findByStartDateBetween (LocalDate before, LocalDate after);
}
