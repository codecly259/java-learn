package com.codecly.proxy.lesson01;

import com.codecly.proxy.Car;

/**
 * Created by maxinchun on 2016/5/22.
 */
public class Car2 extends Car {
    @Override
    public void move() {
        System.out.println("记录日志开始");
        super.move();
        System.out.println("记录日志结束");
    }
}
