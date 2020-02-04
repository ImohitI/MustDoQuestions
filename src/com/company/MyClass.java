package com.company;

public class MyClass implements  MyInterface {
    @Override
    public void run() {
        System.out.println("RUN bitch");
    }

    @Override
    public void walk() {
        System.out.println("Walk asshole");
    }

    @Override
    public int[] chetan(int[] num) {
        System.out.println("in chetan method");
        num[0]=-1000;
        return num;
    }
}
