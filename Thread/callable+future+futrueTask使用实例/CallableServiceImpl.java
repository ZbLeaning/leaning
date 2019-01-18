package com.imooc.demo.threadForCallable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * @Title: CallableServiceImpl
 * @Description: Callable实现类
 * @date 2019/1/1814:18
 */
public class CallableServiceImpl implements Callable<Integer> {
    private static final Logger logger = LoggerFactory.getLogger(CallableServiceImpl.class);
    private int sum;
    @Override
    public Integer call() throws Exception {
        logger.info("callable子线程开始计算");
        Thread.sleep(2000);
        for (int i = 0; i < 100; i++) {
            sum = sum + i;
        }
        logger.info("callable子线程结束计算");
        return sum;
    }
}
