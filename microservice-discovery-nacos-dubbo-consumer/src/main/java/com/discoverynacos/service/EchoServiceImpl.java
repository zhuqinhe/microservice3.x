package com.discoverynacos.service;

import org.apache.dubbo.config.annotation.Service;
@Service(version = "1.0.0")
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String name) {
        return "Dubbo Hello：" + name;
    }
}
