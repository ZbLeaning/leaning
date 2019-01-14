package com.imooc.demo.trendsProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Title: HelloInvocationHandler
 * @Description: 实现InvocationHandler接口
 * @date 2019/1/1411:00
 */
public class HelloInvocationHandler implements InvocationHandler {
    //委托类对象
    private Object target;

    public HelloInvocationHandler(Object target){
        this.target = target;
    }
    //增强方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("PROXY : " + proxy.getClass().getName());
        // 反射调用，目标方法
        Object result = method.invoke(target, args);
        // 增强逻辑
        System.out.println(method.getName() + " : " + result);
        return result;
    }
}
