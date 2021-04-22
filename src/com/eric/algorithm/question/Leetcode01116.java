package com.eric.algorithm.question;

import com.eric.algorithm.question.Leetcode01116.ZeroEvenOdd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class Leetcode01116 {

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);

        IntConsumer consumer1 = value -> System.out.print(value);
        IntConsumer consumer2 = value -> System.out.print(value);
        IntConsumer consumer3 = value -> System.out.print(value);

        new Thread(() -> {
            try {
                zeroEvenOdd.zero(consumer1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.even(consumer2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.odd(consumer3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }


    static class ZeroEvenOdd {

        private int n;
        volatile int i = 0;
        volatile boolean lastOutputIsZero = false; // 上一个打印是否是 0

        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            try {
                lock.lock();
                if (i <= n) {
                    if (lastOutputIsZero) {
                        condition1.await();
                    }
                    if(!lastOutputIsZero){
                        printNumber.accept(0);
                        lastOutputIsZero = true;
                        i++;
                        condition2.signal();
                        condition1.signal();
                    }else {
                        condition2.signal();
                        condition1.signal();
                    }
                }
            } finally {
                lock.unlock();
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            try {
                lock.lock();
                if (i <= n && i > 0) {
                    if (i % 2 == 0) {
                        condition2.await();
                    }
                    if (lastOutputIsZero && i % 2 != 0) {
                        printNumber.accept(i);
                        condition1.signal();
                        lastOutputIsZero = false;
                        i++;
                    } else {
                        condition3.signal();
                    }
                }
            } finally {
                lock.unlock();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            try {
                lock.lock();
                if (i <= n && i > 0) {
                    if (i % 2 != 0) {
                        condition3.await();
                    }
                    if (lastOutputIsZero && i % 2 == 0) {
                        printNumber.accept(i);
                        condition1.signal();
                        lastOutputIsZero = false;
                        i++;
                    } else {
                        condition2.signal();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }

}
