package concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * AQS学习$
 * <p>
 * 创建时间： 2021/7/17 22:09
 * 博客地址： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻)</a>
 *
 * @author tyrantqiao
 * @version 1.0
 **/
public class AQSLesson {

    public void testLock() {
        ReentrantLock lock = new ReentrantLock();

        lock.lock();

        System.out.println("hello");

        lock.unlock();
    }

    public static void main(String[] args) {
        AQSLesson lesson = new AQSLesson();
        lesson.testLock();
    }
}
