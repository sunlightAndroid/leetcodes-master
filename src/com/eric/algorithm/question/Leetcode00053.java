package com.eric.algorithm.question;

import java.util.Arrays;

public class Leetcode00053 {

    /**
     * 定义 dp[i]为以nums[i]结尾的最大连续和
     * dp(i) = max(dp(i-1) + nums[n], nums[n]);
     * 最后求出dp的最大值
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode00053 solution = new Leetcode00053();
            int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
            int[] nums1 = new int[]{1, 2};
            int[] nums2 = new int[]{-2, -1};
            int result = solution.maxSubArray(nums);
            System.out.println(result);
        }
    }

}
