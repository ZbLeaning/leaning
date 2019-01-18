package com.imooc.demo.threadForCallable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Title: FutureClient
 * @Description:
 * @date 2019/1/1814:21
 */
public class FutureClient {
    private static final Logger logger = LoggerFactory.getLogger(FutureClient.class);

    public static void main(String[] args) {
        //创建线程池
        ExecutorService es = Executors.newSingleThreadExecutor();
        //创建任务
        CallableServiceImpl task = new CallableServiceImpl();
        //提交任务并获取执行结果
        Future<Integer> future = es.submit(task);
        //关闭线程池
        es.shutdown();
        try {
            Thread.sleep(2000);
            if (future.get()!=null){
                logger.info("结果是:"+future.get());
            }else {
                logger.info("未获取到结果");
            }
        } catch (Exception e) {
            logger.error("FutureClient error {}",e);
        }
        logger.info("主线程执行完成");
    }
}
