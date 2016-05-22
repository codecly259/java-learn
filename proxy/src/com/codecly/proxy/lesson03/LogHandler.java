package com.codecly.proxy.lesson03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by maxinchun on 2016/5/22.
 */
public class LogHandler implements InvocationHandler {

    private Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("记录日志开始");
        method.invoke(target);
        System.out.println("记录日志结束");
        return null;
    }
}
