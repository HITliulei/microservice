package com.service.provider.user.controller;


import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import com.service.provider.user.entity.User;
import com.service.provider.user.repository.UserRepository;

import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/userService/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Resource
    ApplicationInfoManager applicationInfoManager;

    @RequestMapping(value = "/down", method = RequestMethod.GET)
    public String down(){
        InstanceInfo info = applicationInfoManager.getInfo();
        String instanceId = info.getInstanceId();
        applicationInfoManager.setInstanceStatus(InstanceInfo.InstanceStatus.DOWN);
        applicationInfoManager.refreshDataCenterInfoIfRequired();
        applicationInfoManager.refreshLeaseInfoIfRequired();
        return instanceId + " DOWN";
    }
    @RequestMapping(value = "/up", method = RequestMethod.GET)
    public String up(){
        InstanceInfo info = applicationInfoManager.getInfo();
        String instanceId = info.getInstanceId();
        applicationInfoManager.setInstanceStatus(InstanceInfo.InstanceStatus.UP);
        applicationInfoManager.refreshDataCenterInfoIfRequired();
        applicationInfoManager.refreshLeaseInfoIfRequired();
        return instanceId + " UP";
    }

    @RequestMapping(value = "/change",method = RequestMethod.GET)
    public void changemetadata(){
        Map<String,String> map = new HashMap<>();
        map.put("my-metadata","更改的自定义数据");
        map.put("2","b");
        applicationInfoManager.registerAppMetadata(map);
        applicationInfoManager.refreshDataCenterInfoIfRequired();
        applicationInfoManager.refreshLeaseInfoIfRequired();
    }


    @RequestMapping(value = "/getinfo",method = RequestMethod.GET)
    public Map<String,String> getinfo(){
        return this.applicationInfoManager.getEurekaInstanceConfig().getMetadataMap();
    }
    @RequestMapping(value = "/getinfo1",method = RequestMethod.GET)
    public Map<String,String> getinfo1(){
        return this.applicationInfoManager.getInfo().getMetadata();
    }

    @RequestMapping("user/{id}")
    public User findOne(@PathVariable("id")Long id){
        return this.userRepository.getOne(id);
    }
}
