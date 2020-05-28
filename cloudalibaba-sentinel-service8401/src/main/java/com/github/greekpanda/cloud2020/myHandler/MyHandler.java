package com.github.greekpanda.cloud2020.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.github.greekpanda.springcloud2020.entities.CommonResult;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/5/28 16:10
 */
public class MyHandler {
    public static CommonResult handlerException(BlockException blockException) {
        return new CommonResult(-1, "自定义错误(handlerException)", null);
    }

    public static CommonResult handlerException2(BlockException blockException) {
        return new CommonResult(-1, "自定义错误1(handlerException1)", null);
    }
}
