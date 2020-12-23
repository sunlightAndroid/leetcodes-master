package com.eric.algorithm.learn;

public class 动态规划 {

    public static void main(String[] args) {
        dp();
    }

    public static void dp() {
        // 音响 3000RMB 4kg， 笔记本电脑4000RMB 2kg ， 吉他1500RMB 1kg
        int line = 3;
        int column = 4; // 3行4列
        int[][] grid = new int[line][column];

        int[] value = new int[] { 3000, 4000, 1500 };
        int[] weight = new int[] { 4, 2, 1 }; // 3行样品 当前的重量

//		int[] value = new int[] { 1500, 3000, 2000, 3000 };
//		int[] weight = new int[] { 1, 4, 3, 1 }; // 3行样品 当前的重量

        int[] gridWeight = new int[] { 1, 2, 3, 4 }; // 每一列对应的背包重量

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0) {
                    grid[i][j] = weight[i] > gridWeight[j] ? 0 : value[0];
                } else {
                    int lastLineV = grid[i - 1][j];
                    int current = 0;
                    if(gridWeight[j] >=weight[i]) {
                        int jj = gridWeight[j] - weight[i];
                        int leftPR = grid[i - 1][jj];
                        current =value[i]+ leftPR;
                    }else {
                        current = lastLineV;
                    }
                    grid[i][j] = Math.max(lastLineV, current);
                }
            }
        }

        // 打印结果二维数组maxValue
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                System.out.printf("%6d", grid[i][j]);
            }
            System.out.println();
        }
    }
}
