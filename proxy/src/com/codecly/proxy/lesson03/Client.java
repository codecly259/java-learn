package com.codecly.proxy.lesson03;

import com.codecly.proxy.Car;
import com.codecly.proxy.Moveable;

import java.lang.reflect.Proxy;


/**
 * JDK动态代理测试类，这里的代理不只是能够代理Car类，而是可以代理所有类(Object)的方法
 * 但被代理类必须要是一个实现接口的类
 * Created by maxinchun on 2016/5/22.
 */
public class Client {
    public static void main(String[] args) {
        Car car = new Car();
        Class<?> cls = car.getClass();
        System.out.println(cls.getName());
        // 代理类记录时间
        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), new TimeHandler(car));
        System.out.println(m.getClass().getName());
        m.move();
        System.out.println("========");
        // 代理类先记录日志，再记录时间
        Moveable logTime = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), new LogHandler(m));
        logTime.move();
    }
}
