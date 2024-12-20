package com.srinath.circuit_breaker.controller;

import com.srinath.circuit_breaker.service.CircuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/circuit")
public class CircuitController {
    @Autowired
    CircuitService circuitService;
    @GetMapping("/test")
    public String circuitMethod(){
        return circuitService.callExternalService();


    }

}
