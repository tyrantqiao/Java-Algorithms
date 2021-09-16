package com.tyrantqiao.algorithms.pattern;

import com.tyrantqiao.algorithms.pattern.shape.IShape;
import com.tyrantqiao.algorithms.pattern.shape.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * $
 * <p>
 * 创建时间： 2021/9/17 7:14
 * 博客地址： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻)</a>
 *
 * @author tyrantqiao
 * @version 1.0
 **/
class FactoryPatternTest {

    FactoryPattern factoryPattern;

    @BeforeEach
    void setUp() {
        factoryPattern = new FactoryPattern();
    }

    @Test
    void getShape() {
        IShape shape = factoryPattern.getShape("circle");
        shape.paint();
    }

    @Test
    void getShapeVersionTwo() {
        IShape shape = factoryPattern.getShapeVersionTwo(Triangle.class);
        Assertions.assertNotNull(shape, "shape不为空");
        shape.paint();
    }
}