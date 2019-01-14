package com.imooc.demo.staticProxy;

/**
 * @Title: CodingServiceImpl
 * @Description: 委托类角色
 * @date 2019/1/1410:38
 */
public class CodingServiceImpl implements CodingService{
    @Override
    public String debug(String name) {
        return name + "发现了bug";
    }

    @Override
    public String unitTest(String msg) {
        return "unitTest Result:" + msg;
    }
}
