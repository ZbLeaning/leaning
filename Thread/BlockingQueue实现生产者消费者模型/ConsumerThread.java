package com.imooc.demo.threadForQueue;

import com.imooc.demo.thread.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: ConsumerThread
 * @Description: 消费者
 * @date 2019/1/1810:07
 */
public class ConsumerThread extends Thread{
    private static final Logger logger = LoggerFactory.getLogger(ConsumerThread.class);
    private Resource resource;
    public ConsumerThread(Resource resource){
        this.resource = resource;
    }
    public void run(){
        while (true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                logger.error("ConsumerThread error {}",e);
            }
            resource.remove();
        }
    }
}
