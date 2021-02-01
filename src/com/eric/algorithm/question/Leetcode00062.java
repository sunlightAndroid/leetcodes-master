package com.eric.algorithm.question;

public class Leetcode00062 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode00062 solution = new Leetcode00062();

//            int result = solution.maxProduct(nums1);
//            System.out.println(result);
        }
    }

}
