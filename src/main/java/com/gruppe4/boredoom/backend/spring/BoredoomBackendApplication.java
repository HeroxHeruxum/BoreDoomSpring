package com.gruppe4.boredoom.backend.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BoredoomBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoredoomBackendApplication.class, args);
    }

}
