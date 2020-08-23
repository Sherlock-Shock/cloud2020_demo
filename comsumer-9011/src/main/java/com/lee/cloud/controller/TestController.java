package com.lee.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestController {

    public static final String SERVER_URL="http://nacos-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/comsumer/test/{name}")
    @SentinelResource(value = "fallback",
            fallback = "handlerFallback",
            blockHandler = "blockHandler")
    public String test(@PathVariable("name") String name){
        if("zs".equals(name)){
            throw new IllegalArgumentException("不允许张三");
        }
        return restTemplate.getForObject(SERVER_URL+"/test/"+name,String.class);
    }

    public String handlerFallback(@PathVariable("name") String name,Throwable e){
        return "不允许张三";
    }

    public String blockHandler(@PathVariable("name") String name, BlockException e){
        return "都错了还一直点击";
    }

}
