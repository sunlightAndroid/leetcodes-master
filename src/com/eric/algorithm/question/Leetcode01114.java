package com.eric.algorithm.question;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;

public class Leetcode01114 {

    public static void main(String[] args) {

        Runnable printer1 = () -> out.print("one");
        Runnable printer2 = () -> out.print("two");
        Runnable printer3 = () -> out.print("three");

        Foo foo = new Foo();
        try {
            new Thread(() -> {
                try {
                    foo.first(printer1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    foo.second(printer2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    foo.third(printer3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

/**
 * 解法一： 通过volatile修饰，可以保证原子操作的线程安全
 */
//class Foo {
//
//    volatile boolean oneDone = false;
//    volatile boolean twoDone = false;
//
//    public Foo() {
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        printFirst.run();
//        oneDone = true;
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        while (!oneDone) ;
//        printSecond.run();
//        twoDone = true;
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        while (!twoDone) ;
//        printThird.run();
//    }
//}


class Foo {

    ReentrantLock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    volatile int num = 1;

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        try {
            lock.lock();
            if (num != 1) {
                condition1.await();
            }
            printFirst.run();
            num = 2;
            condition2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            lock.lock();
            if(num !=2){
                condition2.await();
            }
            printSecond.run();
            num=3;
            condition3.signal();
        } finally {
            lock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            lock.lock();
            if(num !=3){
                condition3.await();
            }
            printThird.run();
        } finally {
            lock.unlock();
        }
    }
}
