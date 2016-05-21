package com.codecly.proxy.lesson02;

import com.codecly.proxy.Car;

/**
 * Created by maxinchun on 2016/5/22.
 */
public class Client {

    public static void main(String[] args) {
        Car car = new Car();
        // 先记录时间，再记录日志
        TimeProxy timeProxy = new TimeProxy(car);
        LogProxy logProxy = new LogProxy(timeProxy);
        logProxy.move();

        // 先记录日志，再记录时间
        LogProxy logProxy1 = new LogProxy(car);
        TimeProxy timeProxy1 = new TimeProxy(logProxy1);
        timeProxy1.move();
    }

}
