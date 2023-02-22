package com.example.chargePointsApi.service;

import com.example.chargePointsApi.entity.SessionEntity;
import com.example.chargePointsApi.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SessionService {
    @Autowired
    public SessionRepository sessionRepository;

    public List<SessionEntity> getAllSessionsWithQuery() {
        try {
            return (List<SessionEntity>) sessionRepository.findAll();
        } catch (Exception e) {
            return (List<SessionEntity>) ResponseEntity.badRequest().body("Unknown error occurred");
        }
    }
    public List<SessionEntity> getAllSessionsWithQuery(LocalDate before, LocalDate after) {
        try {
            return (List<SessionEntity>) sessionRepository.findByStartDateBetween (before, after);
        } catch (Exception e) {
            return (List<SessionEntity>) ResponseEntity.badRequest().body("Unknown error occurred");
        }
    }

}
