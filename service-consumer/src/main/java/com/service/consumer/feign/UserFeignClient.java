package com.service.consumer.feign;


import com.service.consumer.entity.User;
import feign.RequestLine;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;

import com.service.config.FeignConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//
//@FeignClient(name = "microservice-zuul",fallbackFactory = UserFeignFallbackFactory.class)
//@FeignClient(name = "microservice-zuul", configuration = FeignConfig.class,fallbackFactory = UserFeignFallbackFactory.class)
//public interface UserFeignClient {
//
//    @RequestLine("GET/microservice-provider-user/userService/user/{id}")
//    public User findByid(@PathVariable("id")Long id);
//
//}
@FeignClient(name = "microservice-zuul",fallbackFactory = UserFeignFallbackFactory.class)
public interface UserFeignClient {

    @RequestMapping(value = "/microservice-provider-user/userService/user/{id}",method = RequestMethod.GET)
    public User findByid(@PathVariable("id")Long id);

}

@Component
class UserFeignFallbackFactory implements FallbackFactory<UserFeignClient>{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserFeignFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User findByid(Long id) {
                User user = new User();
                user.setAge(10);
                user.setId(-1L);
                return user;
            }
        };
    }
}
