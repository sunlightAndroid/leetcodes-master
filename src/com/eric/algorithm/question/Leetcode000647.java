package com.eric.algorithm.question;

import java.util.ArrayList;
import java.util.List;

public class Leetcode000647 {


    private List<String> res = new ArrayList<>();

    public int countSubstrings(String s) {
        backtrack(0, s, "");
        System.out.println(res.toString());
        return 0;
    }


    private void backtrack(int index, String s, String cur) {
        if (index == s.length()) {
            return;
        }
        String temp = cur;
        res.add(temp);

        for (int i = index; i < s.length(); i++) {
            cur += s.charAt(i);
            backtrack(index + 1, s, cur);
            // 撤销选择
            cur = cur.substring(0, cur.length() - 1);
        }
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode000647 solution = new Leetcode000647();
            String s = "abc";
            solution.countSubstrings(s);
        }
    }
}
