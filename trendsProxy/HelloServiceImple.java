package com.imooc.demo.trendsProxy;

/**
 * @Title: HelloServiceImple
 * @Description: 委托类角色
 * @date 2019/1/1410:59
 */
public class HelloServiceImple implements HelloService{
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }

    @Override
    public String hi(String msg) {
        return "Hi, " + msg;
    }
}
