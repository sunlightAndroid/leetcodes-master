package com.eric.algorithm.question;

public class Leetcode000221 {

    public int maximalSquare2(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = Integer.parseInt(String.valueOf(matrix[i][0]));
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = Integer.parseInt(String.valueOf(matrix[0][j]));
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (Integer.parseInt(String.valueOf(dp[i - 1][j])) > 0 &&
                        Integer.parseInt(String.valueOf(dp[i][j - 1])) > 0 &&
                        Integer.parseInt(String.valueOf(dp[i - 1][j - 1])) > 0) {
                    double lastSide = Double.parseDouble(String.valueOf(dp[i - 1][j - 1]));

                    dp[i][j] = (int) ((Math.sqrt(lastSide) + 1) * (Math.sqrt(lastSide) + 1));
                } else {
                    dp[i][j] = Integer.parseInt(String.valueOf(matrix[i][j]));
                }
            }
        }
        int dpMax = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dpMax = Math.max(dpMax, dp[i][j]);
            }
        }
        return dpMax;
    }


    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1')
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        int maxSide = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }

    public static class Test {
        public static void main(String[] args) {
            Leetcode000221 solution = new Leetcode000221();
            char[][] matrix = {
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'0', '0', '1', '1', '1'},
            };

             char[][] matrix1 = {
                    {'1', '1', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'0', '0', '0', '0', '0'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
            };
            int result = solution.maximalSquare(matrix);
            System.out.println(result);
        }
    }
}
