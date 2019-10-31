package com.service.provider.user.config;

import com.netflix.appinfo.ApplicationInfoManager;
import com.service.provider.utils.EurekaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class test {
    @Qualifier("eurekaApplicationInfoManager")
    @Autowired
    private ApplicationInfoManager applicationInfoManager;
    @PostConstruct
    public void init(){
        Map<String,String> map = new HashMap<>();
        map.put("a","a");
        map.put("b","b");
        applicationInfoManager.registerAppMetadata(map);
        EurekaUtils.initInfoManager(applicationInfoManager);
    }
}
