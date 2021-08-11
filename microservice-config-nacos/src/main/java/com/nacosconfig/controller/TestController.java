package com.nacosconfig.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.nacosconfig.config.TestProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {

    @Autowired
    private TestProperties orderProperties;

     //普通 SpringBoot 项目配置项引入方式主要有

    // @NacosValue(value = "${testConfigTwo}",autoRefreshed = true)
    @Value(value = "${testConfigTwo:null}")
     private String testConfigTwo;
     //使用Nacos作为配置中心后
     //@NacosValue(value = "${testConfigOne:null}",autoRefreshed = true)
     @Value(value = "${testConfigOne:null}")
     private String testConfigOne;
    //@NacosValue(value = "${useLocalCache:null}",autoRefreshed = true)
    @Value(value = "${useLocalCache:null}")
    private String useLocalCache;

    /**
     * 测试 @ConfigurationProperties 注解的配置属性类
     */
    @GetMapping("/test01")
    public TestProperties test01() {
        return orderProperties;
    }


    /**
     * 测试 @Value 注解的属性
     */
    @GetMapping("/test02")
    public Map<String, Object> test02() {
        return new JSONObject()
                .fluentPut("useLocalCache", useLocalCache)
                .fluentPut("testConfigOne", testConfigOne)
                .fluentPut("testConfigTwo", testConfigTwo);
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/logger")
    public void logger() {
        logger.debug("[logger][测试一下]");
    }

}
