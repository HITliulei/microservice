package com.service.consul.consumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class test {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalanced;

    @GetMapping("/test1")
    public String test1(){
        ServiceInstance serviceInstance = loadBalanced.choose("service-consul-provider");
        return restTemplate.getForObject(serviceInstance.getUri().toString() + "/hello/1?name=liulei", String.class);
    }
}
