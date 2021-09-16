package com.tyrantqiao.algorithms.interview.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理对象生成器$
 * <p>
 * 创建时间： 2021/3/15 7:35
 * 博客地址： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻)</a>
 *
 * @author tyrantqiao
 * @version 1.0
 **/
public class SayHelloProxyFactory {
    private final Object target;

    public SayHelloProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("开启事务");
                    Object returnValue = method.invoke(target, args);
                    System.out.println("done");
                    return returnValue;
                });
    }
}
