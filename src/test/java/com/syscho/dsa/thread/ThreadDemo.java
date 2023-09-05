package com.thread;

public class ThreadDemo {
    public static void main(String[] args) {

        ThreadDemo threadDemo = new ThreadDemo();

        threadDemo.execute();
    }

    private void execute() {
        Thread thread = new MyThread();
        thread.setName("b1");
        thread.start();

        Thread thread2 = new MyThread();
        thread2.setName("b2");

        thread.run();;
        thread2.run();
    }
}

class MyThread extends Thread {

    @Override
    public synchronized void start() {
        System.out.println("oveaasdsa stat");
    }

    @Override
    public void run() {
        System.out.println("Thread Executed " + Thread.currentThread().getName());
    }
}