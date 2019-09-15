package com.service.consul.provider.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/hello/{id}")
    public String hello(@RequestParam("name")String name, @PathVariable("id")int id){
        return "hello id 为"+id+" ， 名字为"+ name;
    }
}
