package com.example.chargePointsApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class AppInfoController {
    @Autowired
    @Value("${app.version}")
    private String appVersion;
    @Value("${app.dbversion}")
    private String appDbVersion;

    @GetMapping("app-info")
    public Map<String, String> getAppVersion() {
        HashMap<String, String> response = new HashMap<>();
        response.put("appVersion", appVersion);
        response.put("dbVersion", appDbVersion);
        return response;
    }
}