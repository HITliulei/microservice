package com.service.consul.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy   //  服务网关代理
public class ServiceConsulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsulGatewayApplication.class, args);
    }

}
