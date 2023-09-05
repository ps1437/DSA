package com.syscho.dsa.thread;

public class InterThreadCommuncation {

    private int balance = 5000;

    synchronized int withDraw(int withdrawAmount) {
        System.out.println("before withDraw balance  " + balance);
        System.out.println(" withDraw amount  " + withdrawAmount + "  - " + Thread.currentThread().getName());

        if (withdrawAmount > balance) {
            System.out.println(" Insufficient balance , waiting for deposite" + "  - " + Thread.currentThread().getName());
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        balance = balance - withdrawAmount;
        System.out.println("after withDraw balance  " + balance + "  - " + Thread.currentThread().getName());
        return withdrawAmount;
    }

    synchronized void deposit(int amount) {
        System.out.println("before deposit balance  " + balance +" - "+Thread.currentThread().getName());
        balance = balance + amount;
        System.out.println("after deposit balance  " + balance+ "  - " + Thread.currentThread().getName());
        notify();
    }

    public static void main(String[] args) {
        final InterThreadCommuncation interThreadCommuncation = new InterThreadCommuncation();
        Thread t1 = new Thread(() -> interThreadCommuncation.withDraw(15000));
        t1.setName("Thread1");
        t1.start();

        Thread t2 = new Thread(() -> interThreadCommuncation.deposit(15000));
        t2.setName("Thread2");
        t2.start();
    }
}
