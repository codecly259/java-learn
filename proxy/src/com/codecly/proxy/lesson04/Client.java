package com.codecly.proxy.lesson04;

/**
 * Created by maxinchun on 2016/5/22.
 */
public class Client {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Train train = (Train) proxy.getProxy(Train.class);
        train.move();
    }
}
