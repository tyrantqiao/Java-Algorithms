package interview.proxy;

import interview.proxy.api.ISayHello;
import org.hibernate.proxy.ProxyFactory;
import org.junit.jupiter.api.Test;

import javax.xml.stream.events.StartDocument;

/**
 * 测试静态代理以及动态代理的区别$
 * <p>
 * 创建时间： 2021/3/11 23:49
 * 博客地址： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻)</a>
 *
 * @author tyrantqiao
 * @version 1.0
 **/
public class TestProxy {
    @Test
    public void testStaticProxy() {
        // 目标对象
        ISayHello target = new SayHelloImpl();
        // 代理对象
        SayHelloProxy proxy = new SayHelloProxy(target);
        proxy.sayHello();
    }


    @Test
    public void testStaticProxyWithoutParams() {
        // 目标对象
        ISayHello proxy = new SayHelloProxy();
        proxy.sayHello();
    }

    @Test
    public void testDynamicProxy() {
        ISayHello sayHello = new SayHelloImpl();
        System.out.println(sayHello.getClass());
        ISayHello proxy = (ISayHello) new SayHelloProxyFactory(sayHello).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.sayHello();
    }

    @Test
    public void testCglibProxy() {
        SayHello sayHello = new SayHello();
        System.out.println(sayHello.getClass());
        SayHello proxy = (SayHello) new CglibSayHelloProxyFactory(sayHello).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.sayHello();
    }
}
