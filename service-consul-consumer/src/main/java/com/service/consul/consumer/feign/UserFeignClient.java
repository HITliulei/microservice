package com.service.consul.consumer.feign;


import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient(name = "service-consul-gateway",fallbackFactory = UserFeignFallbackFactory.class)
public interface UserFeignClient {
    @RequestMapping(value = "/service-consul-provider/hello/{id}",method = RequestMethod.GET)
    public String hello(@PathVariable("id")int id, @RequestParam("name")String name);

}


@Component
class UserFeignFallbackFactory implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public String hello(int id, String name) {
                return "调用熔断";
            }
        };
    }
}
