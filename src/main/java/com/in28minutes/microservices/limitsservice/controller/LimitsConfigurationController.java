package com.in28minutes.microservices.limitsservice.controller;

import com.in28minutes.microservices.limitsservice.entity.LimitConfigration;
import com.in28minutes.microservices.limitsservice.propertyconfiguration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration config;

    @GetMapping("/limits")
    public LimitConfigration retrieveLimitsFromConfiguration(){
        return new LimitConfigration(config.getMaximum(), config.getMinimum());
    }
}
