package com.eric.algorithm.question;

/**
 * Created by 戈传光 on 2021/1/12.
 */
public class Leetcode001143 {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty()) return 0;
        int m = text1.length() + 1;
        int n = text2.length() + 1;
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Leetcode001143 sulotion = new Leetcode001143();
//        String text1 = "bsbininm";
//        String text2 = "jmjkbkjkv";
        String text1 = "a";
        String text2 = "aaa";

        int result = sulotion.longestCommonSubsequence(text1, text2);
        System.out.println(result);
    }

}
