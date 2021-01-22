package com.eric.algorithm.question;

public class Leetcode00064 {

    public int minPathSum(int[][] grid) {
        int length = grid.length;
        int[][] dp = new int[100][100];
        // i 列   j行
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0) {
                    dp[i][0] += dp[i - 1][0];
                }
                if (i == 0) {
                    dp[0][j] += dp[0][j - 1];
                }
            }
        }

        return 0;
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode00064 solution = new Leetcode00064();

//            int result = solution.maxProduct(nums1);
//            System.out.println(result);
        }
    }

}
