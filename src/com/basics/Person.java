package com.basics;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Person {

    public  String name;
    public  int age;

    public Person() {
        name = null;
        age  = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void doSomething(){
        System.out.println("just do...");
    }
    @Override
    public int hashCode() {
        return name.hashCode()*age;
    }


}
