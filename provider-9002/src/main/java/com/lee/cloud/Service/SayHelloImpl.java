package com.lee.cloud.Service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SayHelloImpl implements SayHello {
    @Value("${server.port}")
    String serverPort;

    @Override
    public String sayHello(String name) {
        return "hello:"+name+"这里是:"+serverPort;
    }
}
