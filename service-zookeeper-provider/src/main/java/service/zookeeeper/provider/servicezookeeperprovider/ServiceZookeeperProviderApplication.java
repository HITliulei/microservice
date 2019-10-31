package service.zookeeeper.provider.servicezookeeperprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceZookeeperProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZookeeperProviderApplication.class, args);
    }

}
