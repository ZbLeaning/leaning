package com.imooc.demo.threadForQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Title: Resource
 * @Description: 资源池
 * @date 2019/1/1810:31
 */
public class Resource {
    private static final Logger logger = LoggerFactory.getLogger(com.imooc.demo.thread.Resource.class);
    private BlockingQueue blockingQueue = new LinkedBlockingDeque(10);
    /**
     * 取资源
     */
    public synchronized void remove(){
        try {
            blockingQueue.take();
            logger.info("消费者" + Thread.currentThread().getName() + "消耗一件资源," + "当前资源池有" + blockingQueue.size()+ "个资源");
        } catch (InterruptedException e) {
            logger.error("remove error {}",e);
        }
    }

    /**
     * 添加资源
     */
    public synchronized void add(){
        try {
            blockingQueue.put(1);
            logger.info("生产者" + Thread.currentThread().getName()+ "生产一件资源," + "当前资源池有" + blockingQueue.size() + "个资源");
        } catch (InterruptedException e) {
            logger.error("add error {}",e);
        }
    }
}
