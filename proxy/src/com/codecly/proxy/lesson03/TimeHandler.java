package com.codecly.proxy.lesson03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by maxinchun on 2016/5/22.
 */
public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    /**
     * 代理类的具体实现方法
     *
     * @param proxy  被代理对象
     * @param method 被代理对象方法
     * @param args   方法的参数
     * @return 调用那个方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始行驶");
        Long startTime = System.currentTimeMillis();
        method.invoke(target);
        Long endTime = System.currentTimeMillis();
        System.out.println("行驶结束,共行驶" + (endTime - startTime) + "毫秒");
        return null;
    }
}
