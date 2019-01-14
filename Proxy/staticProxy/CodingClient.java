package com.imooc.demo.staticProxy;

/**
 * @Title: CodingClient
 * @Description: 客户端
 * @date 2019/1/1410:42
 */
public class CodingClient {
    public static void main(String[] args) {
        CodingService codingService = new CodingServiceImpl();
        CodingServiceProxy codingServiceProxy = new CodingServiceProxy(codingService);
        codingServiceProxy.debug("西瓜");
        codingServiceProxy.unitTest("好吃呀");
    }
}
