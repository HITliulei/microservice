package com.service.consul.provider.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private ConsulDiscoveryProperties consulDiscoveryProperties;
    @RequestMapping("getMetadata1")
    public List<String> map1(){
        return consulDiscoveryProperties.getTags();
    }
    @RequestMapping("set")
    public void set(){
        consulDiscoveryProperties.getTags().add("test1=test1");
    }

    @RequestMapping("/hello/{id}")
    public String hello(@RequestParam("name")String name, @PathVariable("id")int id){
        return "hello id 为"+id+" ， 名字为"+ name;
    }
}
