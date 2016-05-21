package com.codecly.proxy.lesson02;

import com.codecly.proxy.Car;
import com.codecly.proxy.Moveable;

/**
 * Created by maxinchun on 2016/5/21.
 *使用聚合方式实现代理
 */
public class TimeProxy implements Moveable {

    private Moveable car;

    public TimeProxy(Moveable car) {
        this.car = car;
    }

    @Override
    public void move() {
        System.out.println("开始行驶");
        Long startTime = System.currentTimeMillis();
        car.move();
        Long endTime = System.currentTimeMillis();
        System.out.println("行驶结束,共行驶" + (endTime - startTime) + "毫秒");
    }
}
