package com.codecly.proxy.lesson02;

import com.codecly.proxy.Car;

/**
 * Created by maxinchun on 2016/5/22.
 */
public class Client {

    public static void main(String[] args) {
        Car car = new Car();
        // 先记录时间，再记录日志
        CarTimeProxy carTimeProxy = new CarTimeProxy(car);
        CarLogProxy carLogProxy = new CarLogProxy(carTimeProxy);
        carLogProxy.move();

        // 先记录日志，再记录时间
        CarLogProxy carLogProxy1 = new CarLogProxy(car);
        CarTimeProxy carTimeProxy1 = new CarTimeProxy(carLogProxy1);
        carTimeProxy1.move();
    }

}
