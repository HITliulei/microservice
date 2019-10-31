package com.service.consul.obtain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceConsulObtainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsulObtainApplication.class, args);
    }

}
