package com.service.eureka.service;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaStateChangeListener {
    //服务断线事件
    @EventListener(condition = "#event.replication==false")
    public void listen(EurekaInstanceCanceledEvent eurekaInstanceCanceledEvent) {
        System.out.println("服务断线");
        String appName = eurekaInstanceCanceledEvent.getAppName();
        String serverId = eurekaInstanceCanceledEvent.getServerId();
        MInstanceInfoBean mInstanceInfoBean = new MInstanceInfoBean(serverId,null,null,appName);
        System.out.println(mInstanceInfoBean);
    }
    // 服务注册问题
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        System.out.println("服务注册自带的元数据");
        System.out.println(instanceInfo.getMetadata());
        MInstanceInfoBean mInstanceInfoBean = new MInstanceInfoBean(instanceInfo.getInstanceId(),instanceInfo.getIPAddr(),instanceInfo.getPort(),instanceInfo.getAppName());
        System.out.println("服务注册"+mInstanceInfoBean);
    }

    // 服务续约事件
    @EventListener(condition = "#event.replication==false")
    public void listen(EurekaInstanceRenewedEvent event) {
        InstanceInfo info = event.getInstanceInfo();
        System.out.println("服务续约 "+new MInstanceInfoBean(info.getInstanceId(),info.getIPAddr(),info.getPort(),info.getAppName()));
}

    // 注册中心启动事间
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
    }
    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        //Server启动
        System.out.println("服务启动了");
    }
}
