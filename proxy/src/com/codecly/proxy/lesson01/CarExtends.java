package com.codecly.proxy.lesson01;

import com.codecly.proxy.Car;

/**
 * Created by maxinchun on 2016/5/21.
 * 使用继承方式来代理Car类，重写父类的方法，并在之前和之后添加行为
 */
public class CarExtends extends Car {
    @Override
    public void move() throws InterruptedException {
        System.out.println("开始行驶");
        Long startTime = System.currentTimeMillis();
        super.move();
        Long endTime = System.currentTimeMillis();
        System.out.println("行驶结束,共行驶" + (endTime - startTime) + "毫秒");
    }
}
