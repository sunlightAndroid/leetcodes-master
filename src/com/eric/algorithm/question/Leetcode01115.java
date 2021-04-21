package com.eric.algorithm.question;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Leetcode01115 {

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(2);

        final Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.print("foo");
            }
        };

        final Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.print("bar");
            }
        };


        new Thread() {
            @Override
            public void run() {
                try {
                    fooBar.foo(runnable1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    fooBar.bar(runnable2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    static class FooBar {

        private int n;

        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        volatile int cur = 1; // 1 foo 2 bar


        public FooBar(int n) {
            this.n = n;

        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                try {
                    lock.lock();
                    if (cur == 1) {
                        printFoo.run();
                        cur = 2;
                    } else {
                        condition1.await();
                        condition2.signal();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                try {
                    lock.lock();
                    if (cur == 2) {
                        printBar.run();
                        cur = 1;
                    } else {
                        condition2.await();
                        condition1.signal();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }


}
