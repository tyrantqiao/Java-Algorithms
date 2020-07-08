package lesson;

import org.junit.jupiter.api.Test;

/**
 * @author tyrantqiao
 * @date 2020/7/8
 * email: tyrantqiao@gmail.com
 */
public class StringOptimalTest {
    /**
     * 经典面试题之一：
     *
     * String的创建方式，直接声明，new，intern
     *
     * 直接声明，是用的常量池中的引用地址
     * new，是常量池搞个值，堆中new个新对象，一个新的引用地址指向常量池内的引用
     * intern，与直接声明一致
     *
     */
    @Test
    public void testStrEqual() {
        String a = "123";
        String b = new String("123");
        String c = "123".intern();

        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(b==c);
    }
}
