package com.in28minutes.microservices.limitsservice.controller;

import com.in28minutes.microservices.limitsservice.entity.LimitConfigration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @GetMapping("/limits")
    public LimitConfigration retrieveLimitsFromConfiguration(){
        return new LimitConfigration(1000, 1);
    }
}
