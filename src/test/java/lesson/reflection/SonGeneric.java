package lesson.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @author tyrantqiao
 * @date 2020/8/20
 * email: tyrantqiao@gmail.com
 */
public class SonGeneric extends ParentGeneric {
    public void setMsg(String msg) {
        System.out.println("son try to set msg");
        super.setMsg(msg);
    }

    /**
     * 通过反射时会调用父类函数两次，因为①getMethods()是会把父类以及子类的方法得出
     * ② 子类没有指定String泛型参数，父类的泛型方法setMsg(T msg)泛型擦除后就变为了setMsg(Object msg)了，这样子相当于是不同入参的函数了
     * <p>
     * method name:setMsg parameter:java.lang.String
     * son try to set msg
     * parent try to set msg
     * method name:setMsg parameter:java.lang.Object
     * parent try to set msg
     * ParentGeneric{stringBuilder=,parent talked.
     * ,parent talked.
     * }
     * <p>
     * 但即便声明泛型为String类，在调用子类也是不行的，这是因为泛型依然会擦除类型为Object，而如果你是想复写泛型为String类型的函数，
     * 首先子类也要生成个Object类的函数，进行覆盖，而这个生成子类Object类的过程称为bridge桥接方法，如果你不需要，则可以通过
     * {@code method.isBridge()}进行过滤这些桥接方法
     *
     *
     * <p>
     * <p>
     * Process finished with exit code 0
     */
    @Test
    public void testInvokeSuperSet() {
        SonGeneric son = new SonGeneric();
        Arrays.stream(son.getClass().getMethods())
                .filter(method -> "setMsg".equals(method.getName()))
                .forEach(method -> {
                    System.out.println("method name:" + method.getName() + "，parameter Type:" + method.getParameterTypes()[0].getName());
                    try {
                        method.invoke(son, "go to study");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });

        System.out.println(son.toString());
    }
}
