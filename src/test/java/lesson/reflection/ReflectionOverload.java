package lesson.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author tyrantqiao
 * @date 2020/8/20
 * email: tyrantqiao@gmail.com
 */
public class ReflectionOverload {
    private void weight(int weight) {
        System.out.println("int weight:" + weight);
    }

    private void weight(Integer weight) {
        System.out.println("Integer weight:" + weight);
    }

    /**
     * 反射调用时，不是根据入参的参数类型来决定走哪个参数的，而是通过方法签名来确定方法
     * <p>
     * 像此函数中，{@code .getDeclaredMethod("method", int.class)} 此时使用int.class作为方法签名找到方法的，即便
     * 后面送的是Integer，依然走的是int函数
     *
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void testReflectionOverload() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ReflectionOverload overload = new ReflectionOverload();
        overload.getClass().getDeclaredMethod("weight", int.class).invoke(this, Integer.valueOf(5));
    }

    @Test
    public void testInput() {
        ReflectionOverload overload = new ReflectionOverload();
        overload.weight(5);
        overload.weight(Integer.valueOf(5));
    }
}
