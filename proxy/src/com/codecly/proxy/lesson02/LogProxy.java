package com.codecly.proxy.lesson02;

import com.codecly.proxy.Car;
import com.codecly.proxy.Moveable;

/**
 * Created by maxinchun on 2016/5/22.
 */
public class LogProxy implements Moveable{

    private Moveable car;

    public LogProxy(Moveable car) {
        this.car = car;
    }

    @Override
    public void move() {
        System.out.println("记录日志开始");
        car.move();
        System.out.println("记录日志结束");
    }
}
