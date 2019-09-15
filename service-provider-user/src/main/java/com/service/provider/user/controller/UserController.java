package com.service.provider.user.controller;


import com.service.provider.user.entity.User;
import com.service.provider.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userService/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("user/{id}")
    public User findOne(@PathVariable("id")Long id){
        return this.userRepository.getOne(id);
    }
}
