package com.eric.algorithm.question;

public class Leetcode000766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                int tar = matrix[i][j];
                int ii = i;
                int jj = j;
                while (ii >= 0 && jj >= 0) {
                    if (matrix[ii][jj] != tar) {
                        return false;
                    }
                    ii--;
                    jj--;
                }
            }
        }
        return true;
    }

    public static class Test {
        public static void main(String[] args) {
            Leetcode000766 solution = new Leetcode000766();
            //  [[44,35,39],[15,44,35],[17,15,44],[80,17,15],[43,80,0],[77,43,80]]

            int[][] matrix = {
                    {44, 35, 39},
                    {15, 44, 35},
                    {17, 15, 44},
                    {80, 17, 15},
                    {43, 80, 0},
                    {77, 43, 80},
            };
            boolean res = solution.isToeplitzMatrix(matrix);
            System.out.println(res);
        }
    }
}
