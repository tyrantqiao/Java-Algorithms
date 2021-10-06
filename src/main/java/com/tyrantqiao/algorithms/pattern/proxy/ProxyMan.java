package com.tyrantqiao.algorithms.pattern.proxy;

public class ProxyMan {
    private Student student;

    public ProxyMan(Student student) {
        this.student = student;
    }

    public void findHouse() {
        System.out.println("代理学生找房子");
        student.findHouse();
        System.out.println("帮忙找到了");
    }

    public static void main(String[] args){
        ProxyMan proxyMan=new ProxyMan(new Student());
        proxyMan.findHouse();
    }
}
