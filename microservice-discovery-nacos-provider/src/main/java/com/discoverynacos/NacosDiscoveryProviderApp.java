package com.discoverynacos;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosDiscoveryProviderApp
{
    public static void main( String[] args )
    {
        //System.setProperty("nacos.standalone", "true");
        SpringApplication.run(NacosDiscoveryProviderApp.class,args);
    }
}
