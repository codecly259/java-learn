# 使用cglib实现动态代理

上节课学习了jdk的动态代理，但是jdk的动态代理只能代理那些实现接口的类，而那些没有实现接口的类却不能实现代理。
而cglib不同，它是在使用过程是动态生成被代理类的子类，即继承的方式，所以没有实现接口的类也可以来代理。

## 目标

创建一个没有实现接口的不同类，使用cglib来对其进行代理，给类执行方法时添加日志的记录。

## 特点

1. 针对类来实现代理
2. 对指定目标类产生一个子类，通过方法拦截技术拦截所有父类方法的调用。

## 步骤

1.引入cglib的依赖包

关于依赖包的一些说明：asm.jar,cglib.jar,cglib-nodep.jar

- asm: java字节码操纵框架，它能被用来动态生成类或者增强既有类的功能。[asm官网请戳这里](http://asm.ow2.org/)
- cglib: 封装了asm，简化了asm的操作，实现了在运行期动态生成新的class。 [cglib项目地址](https://github.com/cglib/cglib)
- cglib-nodep: cglib是一个独立的包，不包含asm,而cglib-nodep包含了asm包

如果引入cglib.jar的话，还需要引入asm.jar作为依赖。这里为了方便，直接引入cglib-nodep.jar，[可以在这里下载](https://github.com/cglib/cglib/releases/tag/RELEASE_3_2_2)

2.创建一个普通的火车类Train，它有一个move的方法。

```
public class Train {
    public void move() {
        System.out.println("火车行驶中...");
    }
}
```

3.使用cglib来对Train进行代理，添加日志的记录

创建一个代理类CglibProxy,实现 `MethodInterceptor` 接口,实现 `intercept` 方法

```
@Override
public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
    System.out.println("日志开始...");
    // 代理类调用父类的方法
    proxy.invokeSuper(obj, args);
    System.out.println("日志结束...");
    return null;
}
```

再添加一个获得代理类的方法 `getProxy`

```
// 声明增加类实例
private Enhancer enhancer = new Enhancer();

public Object getProxy(Class clazz) {
    // 设置被代理类字节码，CGLIB根据字节码生成被代理类的子类
    enhancer.setSuperclass(clazz);
    // 设置回调函数，即一个方法拦截
    enhancer.setCallback(this);
    return enhancer.create();
}
```

4.创建测试类Client来测试我们的cglib动态代理的示例

```
public class Client {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Train train = (Train) proxy.getProxy(Train.class);
        train.move();
    }
}
```
