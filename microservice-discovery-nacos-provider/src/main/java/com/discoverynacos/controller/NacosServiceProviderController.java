package com.discoverynacos.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 */
@RestController
public class NacosServiceProviderController {



    @RequestMapping(value= "/test/{string}",method = RequestMethod.GET)
    public String test(@PathVariable String string){
        return "Nacos Service Provider:欢迎 "+string+" 访问";
    }
}
