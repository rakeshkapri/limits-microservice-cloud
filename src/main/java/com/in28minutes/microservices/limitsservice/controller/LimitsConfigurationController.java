package com.in28minutes.microservices.limitsservice.controller;

import com.in28minutes.microservices.limitsservice.entity.LimitConfigration;
import com.in28minutes.microservices.limitsservice.propertyconfiguration.Configuration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sun.org.apache.xalan.internal.utils.XMLSecurityManager;
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

    @GetMapping("/limits-fault-tolerance")
    @HystrixCommand(fallbackMethod = "handleLimitsFault")
    public LimitConfigration retrieveLimitsFaultTolerance(){
        throw new RuntimeException("run time exception");
    }

    private LimitConfigration handleLimitsFault(){
        return new LimitConfigration(5555, 5);
    }
}
