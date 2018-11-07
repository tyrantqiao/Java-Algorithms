package interview;

import leetcode.Calculator;

/**
 * @author tyrantqiao
 * date: 2018/11/7
 * blog: tyrantqiao.com
 * contact: tyrantqiao@icloud.com
 */
public class MethodQuestion {
    public void saySomething(String something) {
        something = something.isEmpty() ? "I'm nothing" : something;
        System.out.println(something);
    }

    public static void main(String[] args) {
        AbstractClass abstractClass = new AbstractClass() {
            @Override
            public void saySomething(String something) {
                super.saySomething(something);
            }
        };
        abstractClass.saySomething("");
    }
}

class AClass {
    /**
     * 以参数类型，数目决定
     * 但方法返回类型不决定重载
     *
     * @param something
     */
    public void saySomething(String something) {
        something = something.isEmpty() ? "I'm A class" : something;
        System.out.println(something);
    }

    public int saySomething(int something) {
        return 0;
    }
}

class BClass extends AClass {
    @Override
    public void saySomething(String something) {
        something = something.isEmpty() ? "I'm B class" : something;
        System.out.println(something);
    }
}

/**
 * o
 * 放了抽象方法的必须为抽象类，抽象类继承后要么实现，要么自身也作为抽象类。
 * 而接口其实就是进化后的抽象类。
 */
abstract class AbstractClass {
    public void saySomething(String something) {
        something = something.isEmpty() ? "I'm abstract class" : something;
        System.out.println(something);
    }
}

class DClass extends AbstractClass {
    @Override
    public void saySomething(String something) {
        super.saySomething("I'm D class");
    }
}
