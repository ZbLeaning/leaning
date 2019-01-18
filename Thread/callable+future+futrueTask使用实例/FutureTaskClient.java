package com.imooc.demo.threadForCallable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Title: FutureTaskClient
 * @Description:
 * @date 2019/1/1814:26
 */
public class FutureTaskClient {
    private static final Logger logger = LoggerFactory.getLogger(FutureTaskClient.class);

    public static void main(String[] args) {
        //创建线程池
        ExecutorService es = Executors.newSingleThreadExecutor();
        //创建任务
        CallableServiceImpl task = new CallableServiceImpl();
        //提交任务
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        es.submit(futureTask);
        //关闭线程池
        es.shutdown();
        try {
            Thread.sleep(2000);
            if (futureTask.get()!=null){
                logger.info("结果是:"+futureTask.get());
            }else {
                logger.info("未获取到结果");
            }
        } catch (Exception e) {
            logger.error("FutureTaskClient error {}",e);
        }
        logger.info("主线程执行完成");
    }
}
