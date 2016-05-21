package com.codecly.proxy;

import java.util.Random;

/**
 * Created by maxinchun on 2016/5/21.
 */
public class Car implements Moveable{
    @Override
    public void move() {
        System.out.println("正在行驶中...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
