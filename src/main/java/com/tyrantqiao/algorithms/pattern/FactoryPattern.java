package com.tyrantqiao.algorithms.pattern;

import com.tyrantqiao.algorithms.pattern.shape.Circle;
import com.tyrantqiao.algorithms.pattern.shape.IShape;
import com.tyrantqiao.algorithms.pattern.shape.Triangle;

import java.lang.reflect.InvocationTargetException;

/**
 * date: 2018/4/30
 * Description: 工厂模式
 * blog https://tyrantqiao.github.io/Blog
 * <p>
 * 解决的什么问题：
 * 比如说现在要cricle.paint()
 * 在God类中{@code Shape circle=new Circle();}
 * {@code circle.paint();}
 * 假如说要加多个triangle.paint();
 * 就要多定义一个 {@code Shape triangle=new Triangle();
 * triangle.paint();}
 * 导致God类依赖严重，臃肿
 * <p>
 * 解决方法就是通过工厂方式，God Class不关心具体实现Shape的细节，只管把自己想要的东西告诉{@link FactoryPattern}的getShape()方法
 *
 * @author tyrantqiao
 * @version 0.0.1
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class FactoryPattern {

    enum ShapeEnum {
        /**
         * 圆形
         */
        CIRCLE("circle"), Triangle("triangle");

        private final String shapes;

        ShapeEnum(String shapes) {
            this.shapes = shapes;
        }

        public String getShape() {
            return shapes;
        }
    }


    /**
     * @param shapeType 形状类型
     * @return 获取类型
     * @apiNote 存在问题，每次加类型都要修改这个方法，后期容易臃肿，改进为反射进行获取类
     */
    public IShape getShape(String shapeType) {
        if (ShapeEnum.CIRCLE.getShape().equals(shapeType)) {
            return new Circle();
        } else if (ShapeEnum.Triangle.getShape().equals(shapeType)) {
            return new Triangle();
        }
        return null;
    }

    /**
     * 进化版，根据类去实例化
     *
     * @param clazz 类
     * @return 实例化后的类
     */
    public IShape getShapeVersionTwo(Class<? extends IShape> clazz) {
        try {
            if (null != clazz) {
                // 假如是内部类的话，此段代码无法运行，请注意
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
