package com.ust.springbootwithfeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFeignClientApplication.class, args);
    }

}
