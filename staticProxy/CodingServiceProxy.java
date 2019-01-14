package com.imooc.demo.staticProxy;

/**
 * @Title: CodingServiceProxy
 * @Description: 代理类
 * @date 2019/1/1410:39
 */
public class CodingServiceProxy implements CodingService{
    private CodingService codingService;

    public CodingServiceProxy(CodingService codingService){
        this.codingService = codingService;
    }

    @Override
    public String debug(String name) {
        System.out.println("预处理...");
        String result = codingService.debug(name);
        System.out.println(result);
        System.out.println("后处理...");
        return result;
    }

    @Override
    public String unitTest(String msg) {
        System.out.println("预处理...");
        String result = codingService.unitTest(msg);
        System.out.println(result);
        System.out.println("后处理...");
        return result;
    }
}
