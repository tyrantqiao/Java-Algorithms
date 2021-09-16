package com.tyrantqiao.algorithms.interview.proxy;

import com.tyrantqiao.algorithms.interview.proxy.api.ISayHello;

/**
 * say hello实现类$
 * <p>
 * 创建时间： 2021/3/11 23:43
 * 博客地址： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻)</a>
 *
 * @author tyrantqiao
 * @version 1.0
 **/
public class SayHelloImpl implements ISayHello {
    @Override
    public void sayHello() {
        System.out.println("你好，我是原本实现类");
    }
}
