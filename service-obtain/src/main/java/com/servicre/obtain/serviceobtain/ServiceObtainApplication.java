package com.servicre.obtain.serviceobtain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceObtainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceObtainApplication.class, args);
    }

}
