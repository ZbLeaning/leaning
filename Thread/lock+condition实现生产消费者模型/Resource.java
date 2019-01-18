package com.imooc.demo.treadForCondition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Title: Resource
 * @Description: 资源池
 * @date 2019/1/1810:31
 */
public class Resource {
    private static final Logger logger = LoggerFactory.getLogger(com.imooc.demo.thread.Resource.class);
    private volatile int num = 0;//当前资源数量
    private int maxSize = 10;//资源池中允许存放的资源数目
    private Lock lock;
    //生产者和消费者的Condition 实例
    private Condition producerCondition;
    private Condition consumerCondition;
    public Resource(Lock lock,Condition producerCondition,Condition consumerCondition){
        this.lock = lock;
        this.producerCondition = producerCondition;
        this.consumerCondition = consumerCondition;
    }
    /**
     * 取资源
     */
    public synchronized void remove(){
        lock.lock();
        //当有资源，消费者可以调用，无资源消费者等待
        try {
            if (num > 0){
                num--;
                logger.info("消费者："+Thread.currentThread().getName()+"消耗了一个资源，池中剩余资源："+num);
                //唤醒生产者
                consumerCondition.signalAll();
            }else {
                try {
                    //消费者等待
                    producerCondition.await();
                    logger.info("资源池已无资源，消费者开始等待");
                } catch (InterruptedException e) {
                    logger.error("remove wait error {}",e);
                }
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * 添加资源
     */
    public synchronized void add(){
        //资源小于可以添加，满了生产者等待
        lock.lock();
        try {
            if (num < maxSize){
                num++;
                logger.info(Thread.currentThread().getName()+"生产了一个资源，池中还有资源："+num);
                //唤醒消费者
                producerCondition.signalAll();
            }else {
                try {
                    //生产者等待
                    consumerCondition.await();
                    logger.info(Thread.currentThread().getName()+"进入等待");
                } catch (InterruptedException e) {
                    logger.error("add wait error {}",e);
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
