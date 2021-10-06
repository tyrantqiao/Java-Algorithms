package com.tyrantqiao.algorithms.pattern.proxy;

public class Student implements Person{
    @Override
    public void findHouse() {
        System.out.println("忙于学业，苦于找房");
    }
}
