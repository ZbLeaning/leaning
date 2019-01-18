package com.imooc.demo.thread;

/**
 * @Title: Client
 * @Description: 客户端
 * @date 2019/1/1810:10
 */
public class Client {
    public static void main(String[] args) {
        Resource resource =new Resource();
        ProducerThread pt1 = new ProducerThread(resource);
        ProducerThread pt2 = new ProducerThread(resource);
        ProducerThread pt3 = new ProducerThread(resource);

        ConsumerThread ct1 = new ConsumerThread(resource);
        ConsumerThread ct2 = new ConsumerThread(resource);
        pt1.start();
        pt2.start();
        pt3.start();
        ct1.start();
    }
}
