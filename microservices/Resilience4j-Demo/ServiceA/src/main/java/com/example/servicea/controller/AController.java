package com.example.servicea.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("/a")
public class AController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8081";

    private static final String SERVICE_A = "serviceA";

    int countOfRetry = 1;

    @GetMapping
//    @CircuitBreaker(name = SERVICE_A, fallbackMethod = "serviceAFallback")
//    @Retry(name = SERVICE_A, fallbackMethod = "serviceAFallback")
    @RateLimiter(name = SERVICE_A)
    public String serviceFromA() {

        System.out.println("Retry Method Called " + countOfRetry + " times at " + new Date());
        countOfRetry++;

        String url = BASE_URL + "/b";
        return restTemplate.getForObject(url, String.class);
    }

    // fallback method for A
    public String serviceAFallback(Exception exception) {
        return "Fallback Method Called for A";
    }

}
