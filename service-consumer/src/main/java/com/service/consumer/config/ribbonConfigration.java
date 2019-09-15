package com.service.consumer.config;

import com.service.config.RibbonConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "microservice-provider-user", configuration = RibbonConfig.class)
public class ribbonConfigration {
}
