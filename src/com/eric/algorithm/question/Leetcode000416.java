package com.eric.algorithm.question;

public class Leetcode000416 {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;

        int m = nums.length + 1;  // 商品个数  nums[m-1]商品价值与重量
        int n = sum + 1;        // 背包容量
        int[][] dp = new int[m][n];

        // dp[i][j] 表示第i件商品时，背包重量为j的 最大价值
        for (int i = 1; i < m; i++) {      // 商品
            for (int j = 1; j < n; j++) {   //背包
                int currentW = nums[i - 1];
                if (j >= currentW) {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i - 1][j - currentW] + currentW);
                }else {
                    dp[i][j] = dp[i-1][j];
                }

                if(dp[i][j] == sum) return true;
            }
        }
        return false;
    }

    public static class Test {
        public static void main(String[] args) {
            Leetcode000416 solution = new Leetcode000416();
            int[] nums = {1,5,11,5};
            int[] nums1 = {14,9,8,4,3,2};
            boolean b = solution.canPartition(nums);
            System.out.println(b);
        }
    }
}
