package com.service.consul.consumer.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
import com.service.consul.config.ribbonConfig;

@Configuration
@RibbonClient(name = "service-consul-provider", configuration = ribbonConfig.class)
public class ribbon {
}
