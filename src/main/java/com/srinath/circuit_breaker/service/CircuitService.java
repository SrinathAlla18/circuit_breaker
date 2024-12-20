package com.srinath.circuit_breaker.service;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CircuitService {
    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name="externalService", fallbackMethod = "fallback")
    public String callExternalService() {
        String url = "http://localhost:4000/simulate";
        String response= restTemplate.getForObject(url, String.class);
        return response;
    }
    public String fallback(Exception e) {
        System.out.println("fallback in invoked");
        return "Fallback invoked: " + e.getMessage();

    }
}
