package com.service.consumer.controller;


import com.service.consumer.entity.User;
import com.service.consumer.feign.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class consumerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(consumerController.class);

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/user/{id}")
    public User findByid(@PathVariable("id")Long id){
        return this.userFeignClient.findByid(id);
    }
    @GetMapping("/users/{id}")
    public User findByid1(@PathVariable("id")Long id){
        return this.restTemplate.getForObject("http://microservice-provider-user/userService/user/"+id,User.class);
    }
    @GetMapping("users1/{id}")
    public User findByid2(@PathVariable("id")Long id){
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        return restTemplate.getForObject(serviceInstance.getUri().toString()+"/userService/user/"+id,User.class);
    }


    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        // 打印当前选择的是哪个节点
        consumerController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }

    @RequestMapping("user-info")
    public List<ServiceInstance> showInfo(@RequestParam("serviceName")String name){
        List<ServiceInstance> list = this.discoveryClient.getInstances(name);
        System.out.println(list.get(0));
        return list;
    }
}
