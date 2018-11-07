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
        something= something.isEmpty() ? "I'm nothing": something;
        System.out.println(something);
    }

    public static void main(String[] args){
        AClass aClass=new BClass();
        aClass.saySomething("");
        Calculator calculator=new Calculator();

        BClass bClass= (BClass) new AClass();
    }
}

class AClass{
    public void saySomething(String something){
        something= something.isEmpty() ? "I'm A class": something;
        System.out.println(something);
    }
}

class BClass extends AClass{
    @Override
    public void saySomething(String something){
        something= something.isEmpty() ? "I'm B class": something;
        System.out.println(something);
    }
}
