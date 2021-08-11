package com.discoverynacos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "discovery-nacos-provider",fallback = EchoserviceFallback.class)
public interface EchoService {
        @GetMapping(value = "/test/{str}")
        String echo(@PathVariable("str") String str);
    }