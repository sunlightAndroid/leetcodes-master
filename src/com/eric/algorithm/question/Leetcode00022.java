package com.eric.algorithm.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Leetcode00022 {

    private static final String LEFT = "(";
    private static final String RIGHT = ")";

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0, "", "", result, 2 * n, 0, 0);
        return result;
    }

    /**
     * @param index      下标
     * @param s          当前左括号 或者 右括号
     * @param currentStr 当前拼接结果
     * @param result     List集合
     * @param n          括号总数量
     * @param leftCount  左括号数量
     * @param rightCount 右括号数量
     */
    private void dfs(int index, String s, String currentStr, List<String> result, int n, int leftCount, int rightCount) {
        currentStr += s;
        if (index == n) {
            if (leftCount == rightCount && isValid(currentStr)) {
                result.add(currentStr);
            }
            return;
        }
        dfs(index + 1, LEFT, currentStr, result, n, leftCount + 1, rightCount);
        dfs(index + 1, RIGHT, currentStr, result, n, leftCount, rightCount + 1);
    }

    /**
     * 判断字符串s是否是有效的括号
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        HashMap<Character, Character> maps = new HashMap<Character, Character>();
        maps.put('(', ')');
        Stack<Character> taStack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (maps.containsKey(c)) {
                taStack.push(c);
            } else {
                // 任务栈栈顶元素要跟之相匹配，否则就是false
                if (taStack.isEmpty()) return false;
                if (maps.get(taStack.peek()) != c) return false;
                taStack.pop();
            }
        }
        return taStack.isEmpty();
    }


    /**
     * 方法二 使用回溯模版解
     */
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis2(int n) {
        backtrack(new StringBuilder(), n, n);
        return ans;
    }

    /**
     * @param cur        当前拼接的字符串结果
     * @param leftCount  剩余的左括号数量
     * @param rightCount 剩余的右括号数量
     */
    private void backtrack(StringBuilder cur, int leftCount, int rightCount) {
        if (leftCount < 0 || rightCount < 0) return;
        if (leftCount > rightCount) return;
        if (leftCount == 0 && rightCount == 0) {
            ans.add(cur.toString());
            return;
        }

        // 做选择
        cur.append('(');
        backtrack(cur, leftCount - 1, rightCount);
        cur.deleteCharAt(cur.length() - 1); // 撤销选择

        // 做选择
        cur.append(')');
        backtrack(cur, leftCount, rightCount - 1);
        cur.deleteCharAt(cur.length() - 1);// 撤销选择
    }

    public static class Test {
        public static void main(String[] args) {
            Leetcode00022 solution = new Leetcode00022();
            List<String> strings = solution.generateParenthesis2(3);
            System.out.println(strings);
        }
    }

}
