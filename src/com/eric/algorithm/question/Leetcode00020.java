package com.eric.algorithm.question;

import java.util.HashMap;
import java.util.Stack;

public class Leetcode00020 {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        HashMap<Character, Character> maps = new HashMap<Character, Character>();
        maps.put('(', ')');
        maps.put('[', ']');
        maps.put('{', '}');
        Stack<Character> taStack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(maps.containsKey(c)) {
                taStack.push(c);
            }else {
                // 任务栈栈顶元素要跟之相匹配，否则就是空
                if(taStack.isEmpty()) return false;
                if(maps.get(taStack.peek()) != c) return false;
                taStack.pop();
            }
        }
        return taStack.isEmpty();
    }

    public static class Test {
        public static void main(String[] args) {

//			String s = "()[]{}";
//			String s = "]";
//			String s = "(])";
//			String s = "([)]";
            String s = "(){}}{";
            boolean result  = isValid(s);
            System.out.print("是否合法：" + result);
        }
    }
}
