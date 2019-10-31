package com.servicre.obtain.serviceobtain.controller;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ObtainEureka {


    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    DiscoveryClient discoveryClient;

//    @Autowired
//    Registration registration;
//
//
//    // 得到自身的注册信息
//
//    @RequestMapping("getallServices2")
//    public List<ServiceInstance> getallServices(){
//        List<ServiceInstance> list = discoveryClient.getInstances(registration.getServiceId());
//        if (list != null && list.size() > 0){
//            return list;
//        }
//        return null;
//    }


    @RequestMapping("getallServices")
    public List<ServiceInstance> getallServices1(){
        List<ServiceInstance> list = new ArrayList<>();
        List<String> servicename = discoveryClient.getServices();
        for(String name:servicename){
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(name);
            for(ServiceInstance serviceInstance :serviceInstances){
                if(serviceInstance.getMetadata()!=null && serviceInstance.getMetadata().size() >1 ){
                    System.out.println(serviceInstance.getMetadata());
                    System.out.println("这个微服务"+serviceInstance.getInstanceId()+"          "+serviceInstance.getServiceId()+"拥有自身的额外信息");
                    System.out.println(serviceInstance.getMetadata().get("my-metadata2.my-metadata1"));
                }
            }
            list.addAll(serviceInstances);
        }
        return list;
    }
}
