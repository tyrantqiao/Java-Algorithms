package com.tyrantqiao.algorithms.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk invocationHandle 动态代理
 *
 * @author tyrantqiao
 */
public class JDKProxyHouse implements InvocationHandler {
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;

        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target, args);
        after();
        return obj;
    }

    public void before() {
        System.out.println("这里是52同城中介所");
    }

    public void after() {
        System.out.println("很高兴为您服务，欢迎下次再来");
    }


}
