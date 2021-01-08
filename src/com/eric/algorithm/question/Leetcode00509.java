package com.eric.algorithm.question;

import java.util.HashMap;
import java.util.Map;

public class Leetcode00509 {

    HashMap<Integer,Integer> maps = new HashMap<>();
    public int fib(int n) {
        if (n < 2) return n;
        if(!maps.containsKey(n - 1)){
            maps.put(n -1 , fib(n - 1));
        }
        if(!maps.containsKey(n - 2)){
            maps.put(n -2 , fib(n - 2));
        }
        return maps.get(n - 1) + maps.get(n - 2);
    }


    static class Test {
        public static void main(String[] args) {
            Leetcode00509 solution = new Leetcode00509();
            int result = solution.fib(7);
            System.out.println(result);
        }
    }
}
