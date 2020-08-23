package com.lee.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Provider9001 {
    public static void main(String args[]){
        SpringApplication.run(Provider9001.class, args);
    }
}
