package com.example.devflowsample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class HelloController {

    @Value("${app.environment:unknown}")
    private String environment;

    @GetMapping("/")
    public Map<String, String> hello() {
        return Map.of(
                "message", "DevFlow Sample App",
                "environment", environment,
                "status", "running"
        );
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }
}
