package com.service.eureka.clientdemo.controller;


import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class test1 {

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
        map.put("third","3");
        map.put("fourth","4");
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
}
