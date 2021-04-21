package com.eric.algorithm.question;

public class leetcode0005 {

    //  s = "babad"    aba
    private String max = "";

    public String longestPalindrome(String s) {
        backtrace(0,s.toCharArray(),new StringBuilder());
        return max;
    }


    private void backtrace(int start, char[] strArray, StringBuilder cur) {
        System.out.println(cur);
        if(check(cur)){
            if(max.length() < cur.length()) max = cur.toString();
        }
        for (int i = start; i < strArray.length; i++) {
            cur.append(strArray[i]);
            backtrace(i + 1, strArray, cur);
            cur.deleteCharAt(cur.length() - 1);
        }

    }


    private boolean check(StringBuilder stringBuilder) {
        int i = 0;
        int j = stringBuilder.length() - 1;

        while (i < j) {
            if (stringBuilder.charAt(i) != stringBuilder.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "cbbd";
        leetcode0005 solution = new leetcode0005();
        String res = solution.longestPalindrome(s);
        System.out.println("==========");
        System.out.println(res);
    }


}
