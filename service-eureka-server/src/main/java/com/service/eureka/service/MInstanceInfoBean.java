package com.service.eureka.service;

public class MInstanceInfoBean {
    private String id;	// 服务中心中的实例ID
    private String ip;	// ip 地址
    private Integer port;	// 端口号
    private String serviceName;

    public MInstanceInfoBean(String id, String ip, Integer port, String serviceName) {
        this.id = id;
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "MInstanceInfoBean{" +
                "id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
