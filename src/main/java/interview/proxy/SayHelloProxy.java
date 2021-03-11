package interview.proxy;

import interview.proxy.api.ISayHello;

/**
 * sayHello的静态代理类$
 * <p>
 * 创建时间： 2021/3/11 23:45
 * 博客地址： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻)</a>
 *
 * @author tyrantqiao
 * @version 1.0
 **/
public class SayHelloProxy implements ISayHello {

    private final ISayHello target;

    public SayHelloProxy() {
        this.target = new SayHelloImpl();
    }

    /**
     * 赋值式的代理
     *
     * @param sayHello sayHello
     */
    public SayHelloProxy(ISayHello sayHello) {
        this.target = sayHello;
    }

    @Override
    public void sayHello() {
        System.out.println("我是代理类，实现代理方法前，说句话");
        target.sayHello();
        System.out.println("我是代理类，实现代理方法后，说句话");
    }
}
