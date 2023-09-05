package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class InnerClasses {
    public static void main(String[] args) {

        List<String> list = new LinkedList<>();

        String s = list.get(12);


    }


}

class A {
    static void test() {
        System.out.println("test method");
    }

}

class B extends A {
    static void test() {
        System.out.println("test method2");
    }

}
