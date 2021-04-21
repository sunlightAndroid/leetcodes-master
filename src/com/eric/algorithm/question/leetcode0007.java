package com.eric.algorithm.question;

public class leetcode0007 {

    public int reverse(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        StringBuilder builder = new StringBuilder();
        String last = "";
        for (int i = 0; i < chars.length; i++) {
            String cur = String.valueOf(chars[i]);
            builder.append(cur);
            builder.append(last);
            last = builder.toString();
        }
        return Integer.parseInt(builder.toString());
    }



    public static void main(String[] args) {
        leetcode0007 solution = new leetcode0007();
        int reverse = solution.reverse(123);
        System.out.println(reverse);

    }

}
