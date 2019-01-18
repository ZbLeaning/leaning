package com.imooc.demo.threadForQueue;

import com.imooc.demo.thread.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: ProducerThread
 * @Description: 生产者
 * @date 2019/1/1810:08
 */
public class ProducerThread extends Thread{
    private static final Logger logger = LoggerFactory.getLogger(ProducerThread.class);
    private Resource resource;
    public ProducerThread(Resource resource){
        this.resource = resource;
    }
    public void run(){
        while (true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                logger.error("ProducerThread error {}",e);
            }
            resource.add();
        }
    }
}
