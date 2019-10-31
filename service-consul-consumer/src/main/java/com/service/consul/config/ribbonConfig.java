package com.service.consul.config;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ribbonConfig {
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
