package com.eric.algorithm.question;

import java.util.Stack;

public class Leetcode00032 {


    //------------解法一 迭代--------------//
    public static final char LEFT = '(';
    public static final char RIGHT = ')';
    int result = 0;

    public int longestValidParentheses(String s) {
        for (int i = 0; i < s.length(); i++) {
            String chars = "";
            for (int j = i; j < s.length(); j++) {
                chars += String.valueOf(s.charAt(j));
                if (chars.length() % 2 == 0 && s.charAt(j) == RIGHT)
                    isValid(chars);
            }
        }
        return result * 2;
    }

    /**
     * 判断字符串是不是有效的括号
     *
     * @param chars 字符串
     */
    private void isValid(String chars) {
        int pair = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length(); i++) {
            if (chars.charAt(i) == LEFT) {
                stack.push(LEFT);
            } else if (chars.charAt(i) == RIGHT) {
                if (stack.isEmpty()) {
                    return;
                } else if (stack.peek() == LEFT) {
                    pair++;
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) result = Math.max(pair, result);
    }


    //------------解法二 动态规划--------------//
    public int longestValidParentheses2(String s) {
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                // 找对称位置j: i-dp[i-1]-1  是否能跟当前匹配
                // 对称位置之前的记录长度 也给加上， 即 dp[j - 1]
                int j = i - dp[i - 1] - 1;
                if (j >= 0 && s.charAt(j) == '(')
                    dp[i] = (i - j + 1) + ((j - 1) >= 0 ? dp[j - 1] : 0);
            }
        }
        int max = 0;
        for (int j : dp) {
            max = Math.max(max, j);
        }
        return max;
    }

    public static class Test {
        public static void main(String[] args) {
            Leetcode00032 solution = new Leetcode00032();
            String s = "(())";
            String s1 = "()(()";
            String s2 = ")()())";
            int res = solution.longestValidParentheses2(s1);
            System.out.println(res);
        }
    }
}
