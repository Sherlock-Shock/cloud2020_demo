package com.lee.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lee.cloud.myhandler.MyBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @auther zzyy
 * @create 2020-02-24 16:26
 */
@RestController
@Slf4j
public class FlowLimitController
{
    //在nacos配置了规则
    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        try {
            TimeUnit.SECONDS.sleep(1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName()+"\t"+"....testB");
        return "------testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2)
    {

        return "------testHotKey";
    }

    @GetMapping("/testHandler")
    @SentinelResource(value = "testHandler",
            blockHandlerClass = MyBlockHandler.class,
            blockHandler = "handler2")
    public String testHandler()
    {
        return "------testHandler";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exc){
        return "------deal_testHotKey";
    }



}
