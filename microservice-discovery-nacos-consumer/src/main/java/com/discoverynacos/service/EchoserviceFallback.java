package com.discoverynacos.service;

import org.springframework.stereotype.Component;

@Component
public class EchoserviceFallback implements  EchoService{
    @Override
    public String echo(String str) {
        return "服务异常，请稍后重试。。。";
    }
}
