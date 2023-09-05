package com;

public class Inner {
    public void test() {
        System.out.println("inner");

    }

    final class Inner2 {
        public void test() {
            System.out.println("Inner2");

        }
    }
}