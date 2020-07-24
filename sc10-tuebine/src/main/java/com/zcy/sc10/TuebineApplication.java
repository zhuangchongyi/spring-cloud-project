package com.zcy.sc10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine //启用turbine
@EnableDiscoveryClient
@SpringBootApplication
public class TuebineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TuebineApplication.class, args);
    }

}
