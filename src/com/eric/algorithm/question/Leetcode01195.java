package com.eric.algorithm.question;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class Leetcode01195 {

    public static void main(String[] args) {
        FizzBuzz buzz = new FizzBuzz(15);
        Runnable runnable1 = () -> System.out.print("fizz");
        Runnable runnable2 = () -> System.out.print("buzz");
        Runnable runnable3 = () -> System.out.print("fizzbuzz");
        IntConsumer consumer = value -> System.out.print(value);

        new Thread(() -> {
            try {
                buzz.fizz(runnable1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                buzz.buzz(runnable2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                buzz.fizzbuzz(runnable3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                buzz.number(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }


    public static class FizzBuzz {
        private int n;
        volatile int num = 1;
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        Condition condition4 = lock.newCondition();

        volatile int cur = 1;

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz". 被 3 整除
        public void fizz(Runnable printFizz) throws InterruptedException {
            try {
                lock.lock();
                while (num <= n) {
                    for (int i = num; i <= n; i++) {
                        if (num % 3 != 0) {
                            condition1.await();
                        }
                        printFizz.run();
                        num++;
                        condition4.signal();
                    }
                }
            } finally {
                lock.unlock();
            }
        }

        // printBuzz.run() outputs "buzz". 被 5 整除
        public void buzz(Runnable printBuzz) throws InterruptedException {
            try {
                lock.lock();
                while (num <= n) {
                    for (int i = num; i <= n; i++) {
                        if (num % 5 != 0) {
                            condition2.await();
                        }
                        printBuzz.run();
                        num++;
                        condition4.signal();
                    }
                }
            } finally {
                lock.unlock();
            }

        }

        // printFizzBuzz.run() outputs "fizzbuzz". 被 3跟5 整除
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            try {
                lock.lock();
                while (num <= n) {
                    for (int i = num; i <= n; i++) {
                        if (!(num % 5 == 0 && num % 3 == 0)) {
                            condition3.await();
                        }
                        printFizzBuzz.run();
                        num++;
                        condition4.signal();
                    }
                }
            } finally {
                lock.unlock();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            try {
                lock.lock();
                while (num <= n) {
                    for (int i = num; i <= n; i++) {
                        if (num % 5 == 0 && num % 3 == 0) {
                            condition4.await();
                        }
                        printNumber.accept(i);
                        num++;
                        condition1.signal();
                        condition2.signal();
                        condition4.signal();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }


}
