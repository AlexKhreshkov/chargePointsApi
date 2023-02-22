package com.example.chargePointsApi.controller;

import com.example.chargePointsApi.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@RestController
@RequestMapping("/session/")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @GetMapping
    //session/?from=1/1/2022&to=1/1/2023
    public ResponseEntity getAllSessionsWithQueries(
            @RequestParam(name = "from", defaultValue = "") String before,
            @RequestParam(name = "to", defaultValue = "") String after
    ) {
        try {
            if (Objects.equals(before, "") && Objects.equals(after, "")) {
                return ResponseEntity.ok(sessionService.getAllSessionsWithQuery());
            }
            LocalDate dateBefore = LocalDate.parse(before, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate dateAfter = LocalDate.parse(after, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return ResponseEntity.ok(sessionService.sessionRepository.findAll());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Unknown error occurred");
        }
    }
}
