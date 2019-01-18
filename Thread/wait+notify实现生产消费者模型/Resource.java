package com.imooc.demo.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Resource
 * @Description: 公共资源类
 * @date 2019/1/189:56
 */
public class Resource {
    private static final Logger logger = LoggerFactory.getLogger(Resource.class);
    //当前资源池数
    private int num = 0;
    //池中最大数
    private int maxSize = 10;

    /**
     * 取资源
     */
    public synchronized void remove(){
        //当有资源，消费者可以调用，无资源消费者等待
        if (num > 0){
            num--;
            logger.info("消费者："+Thread.currentThread().getName()+"消耗了一个资源，池中剩余资源："+num);
            //唤醒生产者
            notifyAll();
        }else {
            try {
                //消费者等待
                wait();
                logger.info("资源池已无资源，消费者开始等待");
            } catch (InterruptedException e) {
                logger.error("remove wait error {}",e);
            }
        }
    }

    /**
     * 添加资源
     */
    public synchronized void add(){
        //资源小于可以添加，满了生产者等待
        if (num < maxSize){
            num++;
            logger.info(Thread.currentThread().getName()+"生产了一个资源，池中还有资源："+num);
            //唤醒消费者
            notifyAll();
        }else {
            try {
                //生产者等待
                wait();
                logger.info(Thread.currentThread().getName()+"进入等待");
            } catch (InterruptedException e) {
                logger.error("add wait error {}",e);
            }
        }
    }
}
