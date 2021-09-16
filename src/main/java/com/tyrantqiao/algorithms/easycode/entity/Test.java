package com.tyrantqiao.algorithms.easycode.entity;

import java.io.Serializable;

/**
 * (Test)实体类
 *
 * @author makejava
 * @since 2020-03-01 15:58:16
 */
public class Test implements Serializable {
    private static final long serialVersionUID = 572311108595594950L;
    
    private Integer a;
    
    private Integer b;
    
    private Integer c;
    
    private Integer id;


    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}