package com.imooc.demo.trendsProxy;

import java.lang.reflect.Proxy;

/**
 * @Title: HelloClient
 * @Description: 客户端
 * @date 2019/1/1411:04
 */
public class HelloClient {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImple();
        //创建代理类并生成相应代理对象
        HelloService proxy = (HelloService)Proxy.newProxyInstance(HelloService.class.getClassLoader(),
                helloService.getClass().getInterfaces(), new HelloInvocationHandler(helloService));
        proxy.hello("rico");
        proxy.hi("panda");
    }
}
