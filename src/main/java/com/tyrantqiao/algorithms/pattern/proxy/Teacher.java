package com.tyrantqiao.algorithms.pattern.proxy;

public class Teacher implements Person{

    @Override
    public void findHouse() {
        System.out.println("忙于教书");
    }
}
