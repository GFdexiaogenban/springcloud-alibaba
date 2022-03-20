package com.ckj.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ckj.entities.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(4444,"自定义global handlerException-----1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444,"自定义global handlerException-----2");
    }
}
