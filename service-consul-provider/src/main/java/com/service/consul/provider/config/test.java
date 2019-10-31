package com.service.consul.provider.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClient;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
//@Configuration
//@EnableConfigurationProperties
//@ConditionalOnBean(ConsulDiscoveryProperties.class)
public class test {

    @Autowired
    private ConsulDiscoveryProperties properties;


    @PostConstruct
    public void init(){
        System.out.println("执行了");
        List<String> list = new ArrayList<>();
        list.add("test=test");
//        properties.setTags(list);
        properties.getTags().add("consul1=consul1");
        System.out.println(properties.getTags());
    }

}
