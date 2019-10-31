package com.service.eureka.service;

/**
 * eureka事件监听
 * 例如：用于监听eureka服务停机通知
 *
 * @author hrabbit
 * @date 2018-09-13
// */
//@Configuration
//@EnableScheduling
//public class EurekaChangeState implements ApplicationListener {
//    private Logger log = LoggerFactory.getLogger(EurekaChangeState.class);
//
//    @Override
//    public void onApplicationEvent(ApplicationEvent applicationEvent) {
//        // EurekaInstanceCanceledEvent 服务下线事件
//        if (applicationEvent instanceof EurekaInstanceCanceledEvent) {
//            EurekaInstanceCanceledEvent event = (EurekaInstanceCanceledEvent) applicationEvent;
//            // 获取当前Eureka实例中的节点信息
//            PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
//            Applications applications = registry.getApplications();
//            // 遍历获取已注册节点中与当前失效节点ID一致的节点信息
//            applications.getRegisteredApplications().forEach((registeredApplication) -> {
//                registeredApplication.getInstances().forEach((instance) -> {
//                    if (instance.getInstanceId().equals(event.getServerId())) {
//                        log.info("服务：" + instance.getAppName() + " 挂啦。。。");
//                        System.out.println("服务断线");
//                        // TODO: 2018-09-13 扩展消息提醒 邮件、手机短信、微信等
//                    }
//                });
//            });
//        }
//        //EurekaInstanceRegisteredEvent 服务注册事件
//        if (applicationEvent instanceof EurekaInstanceRegisteredEvent) {
//            EurekaInstanceRegisteredEvent event = (EurekaInstanceRegisteredEvent) applicationEvent;
//            log.info("服务：" + event.getInstanceInfo().getAppName() + " 注册成功啦...");
//        }
//        //EurekaInstanceRenewedEvent 服务续约事件
//        if (applicationEvent instanceof EurekaInstanceRenewedEvent) {
//            EurekaInstanceRenewedEvent event = (EurekaInstanceRenewedEvent) applicationEvent;
//            log.info("服务：" + event.getInstanceInfo().getAppName() + "续约...");
//        }
//        //EurekaRegistryAvailableEvent Eureka注册中心启动事件
//        if (applicationEvent instanceof EurekaRegistryAvailableEvent) {
//            log.info("Eureka注册中心启动了...");
//        }
//
//    }
//}
