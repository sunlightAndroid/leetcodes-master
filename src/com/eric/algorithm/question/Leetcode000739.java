package com.eric.algorithm.question;

import java.util.HashMap;
import java.util.Stack;

public class Leetcode000739 {

    // [73, 74, 75, 71, 69, 72, 76, 73]
    // [1,  1,   4, 2,   1,  1,  0,  0]。
    public int[] dailyTemperatures(int[] T) {
        if (T == null) return null;
        int[] res = new int[T.length];
        for (int i = 0; i < T.length - 1; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    // 优化一下
    public int[] dailyTemperatures2(int[] T) {
        if (T == null) return null;
        int[] dp = new int[T.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < T.length - 1; i++) {
            if (map.containsKey(i)) {
                int min_index = map.get(i);
                dp[i] = min_index - i > 0 ? min_index : 0;
            } else {
                for (int j = i + 1; j < T.length; j++) {
                    if (T[j] > T[i]) {
                        map.put(i, j);

                        dp[i] = j - i;
                        break;
                    }
                }
            }
        }
        return dp;
    }


    // 单调栈，栈内都是有序的
    // [73, 74, 75, 71, 69, 72, 76, 73]
    // [1,  1,   4, 2,   1,  1,  0,  0]。
    public int[] dailyTemperatures3(int[] T) {
        if (T == null) return null;
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - 1;
            stack.push(i);
        }
        return res;
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode000739 solution = new Leetcode000739();
            int[] array = {73, 74, 75, 71, 69, 72, 76, 73};
            solution.dailyTemperatures3(array);
        }
    }
}
