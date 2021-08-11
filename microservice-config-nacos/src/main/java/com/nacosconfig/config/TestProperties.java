package com.nacosconfig.config;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@NacosConfigurationProperties(dataId = "config-nacos", type = ConfigType.YAML,autoRefreshed = true)
@ConfigurationProperties(prefix = "hoobtest")
public class TestProperties {

    /**
     * 测试配置1
     */
    private String  testConfigOne;

    /**
     * 测试配置2
     */
    private String testConfigTwo;

    public String  getTestConfigOne() {
        return testConfigOne;
    }

    public TestProperties setTestConfigOne(String testConfigOne) {
        this.testConfigOne = testConfigOne;
        System.out.println("==============testConfigOne============="+testConfigOne);
        return this;
    }

    public String getTestConfigTwo() {
        return testConfigTwo;
    }

    public TestProperties setTestConfigTwo(String testConfigTwo) {
        this.testConfigTwo = testConfigTwo;
        return this;
    }


}
