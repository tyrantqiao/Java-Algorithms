package com.tyrantqiao.algorithms.pattern.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tyrantqiao
 * @date 二〇二一年十月六日 15:58:01
 */
class JDKProxyHouseTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void invoke() {
        Person student = (Person) new JDKProxyHouse().getInstance(new Student());
        student.findHouse();

        Person teacher = (Person) new JDKProxyHouse().getInstance(new Teacher());
        teacher.findHouse();
    }
}