package com.codecly.proxy.lesson04;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by maxinchun on 2016/5/22.
 */
public class CglibProxy implements MethodInterceptor {

    // 声明增加类实例
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        // 设置被代理类字节码，CGLIB根据字节码生成被代理类的子类
        enhancer.setSuperclass(clazz);
        // 设置回调函数，即一个方法拦截
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * 拦截所有目标类方法的调用
     *
     * @param obj    目标类的实例
     * @param method 目标方法的反射对象
     * @param args   方法的参数
     * @param proxy  代理类的实例
     * @return 被代理方法的返回值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("日志开始...");
        // 代理类调用父类的方法
        proxy.invokeSuper(obj, args);
        System.out.println("日志结束...");
        return null;
    }
}
