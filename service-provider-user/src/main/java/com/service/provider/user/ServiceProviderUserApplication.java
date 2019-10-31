package com.service.provider.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



//@EnableDiscoveryClient  在Edgware 以及更高的版本   这个可以删除 这个可以针对任何一个 注册中心
//@EnableEurekaClient 这个只针对Eureka服务注册中心
@SpringBootApplication
public class ServiceProviderUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderUserApplication.class, args);
    }
}
