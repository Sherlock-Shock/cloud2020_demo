package com.lee.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClient3373 {
    public static void main(String args[]){
        SpringApplication.run(NacosConfigClient3373.class,args);
    }
}
