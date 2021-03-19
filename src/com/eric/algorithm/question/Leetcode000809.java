package com.eric.algorithm.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode000809 {

    private List<String> res = new ArrayList<>();
    boolean[] visited;

    public List<String> generateParenthesis(int n) {
        visited = new boolean[2 * n];
        char[] choice = new char[2 * n];
        for (int i = 0; i < choice.length; i++) {
            if (i < n) {
                choice[i] = '(';
            } else {
                choice[i] = ')';
            }
        }
        backtrack(choice, "",0);
        return res;
    }


    private void backtrack(char[] choice, String cur,int index) {
        System.out.println(cur);
        if (isAvoid(cur)) res.add(cur);
        if(cur.length() == choice.length){
          return;
        }
        for (int i = index; i < choice.length; i++) {
            if (!visited[i]) {
                cur += choice[i];
                visited[i] = true;
                backtrack(choice, cur,index+1);
                cur = cur.substring(0, cur.length() - 1);
                visited[i] = false;
            }
        }
    }

    /**
     * 判断字符串是不是有效的括号
     */
    private boolean isAvoid(String s) {
        if (s.length() == 0) return false;
        if (s.length() % 2 != 0) return false;
        if (s.charAt(0) == ')') return false;
        if (s.charAt(s.length() - 1) == '(') return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(')
                stack.push(cur);
            else {
                if (stack.isEmpty() || stack.peek() != '(')
                    return false;
                else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static class Test {
        public static void main(String[] args) {
            Leetcode000809 solution = new Leetcode000809();
            List<String> strings = solution.generateParenthesis(2);
            System.out.println(strings);
        }
    }
}
