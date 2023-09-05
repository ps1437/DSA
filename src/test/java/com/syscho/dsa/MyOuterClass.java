package com;

public class MyOuterClass {
    public static class MyInnerClass {
        public void display() {
            System.out.println("Inside the inner class");
        }
    }

    public static void main(String[] args) {
        MyOuterClass.MyInnerClass obj = new MyOuterClass.MyInnerClass();


    }
}