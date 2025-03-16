package com.example.crossfunctionalapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/api")
public class CrossFunctionalController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.service.endpoint}")
    private String userServiceEndpoint;

    @Value("${order.service.endpoint}")
    private String orderServiceEndpoint;

    @GetMapping("/cross-functional")
    public String getCrossFunctionalData() {
        // Call UserService
        String userServiceResponse = restTemplate.getForObject(userServiceEndpoint, String.class);

        // Call OrderService
        String orderServiceResponse = restTemplate.getForObject(orderServiceEndpoint, String.class);

        // Combine responses
        return "UserService Response: " + userServiceResponse + ", OrderService Response: " + orderServiceResponse;
    }
}
