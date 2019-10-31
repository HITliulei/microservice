package com.service.consul.obtain.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ObtainConsul {


    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    LoadBalancerClient loadBalancerClient;


    @RequestMapping("getMetadata")
    public Map<String,String> map(){
        List<ServiceInstance> list = discoveryClient.getInstances("service-consul-provider");
        return list.get(0).getMetadata();
    }



    @RequestMapping("getallService")
    public List<ServiceInstance> getallService(){
        List<ServiceInstance> list = new ArrayList<>();
        List<String> servicename = discoveryClient.getServices();
        for (String name : servicename) {
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(name);
            list.addAll(serviceInstances);
        }
        System.out.println(list.get(2).getMetadata().get("version"));
        return list;
    }
}
