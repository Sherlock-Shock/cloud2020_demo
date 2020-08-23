package com.lee.cloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class MyBlockHandler {
    public static String handler1(BlockException blockException){
        return "-----handler-----1";
    }
    public static String handler2(BlockException blockException){
        return "-----handler-----2";
    }
}
