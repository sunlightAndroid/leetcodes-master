package com.eric.algorithm.question;

import java.util.Arrays;

public class Leetcode000152 {

    /**
     * 定义 dp[i]为以nums[i]结尾的最大连续和
     * dp(i) = max(dp(i-1) + nums[n], nums[n]);
     * 最后求出dp的最大值
     */
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int len = nums.length;
        int[] dpMax = new int[len];
        int[] dpMin = new int[len];
        dpMax[0] = dpMin[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], nums[i]);
            dpMax[i] = Math.max(dpMin[i-1]* nums[i], dpMax[i]);
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], nums[i]);
            dpMin[i] = Math.min(dpMax[i-1]* nums[i], dpMin[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dpMax.length; i++) {
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode000152 solution = new Leetcode000152();
            int[] nums = new int[]{-2, 3, 4};
            int[] nums1 = new int[]{-3,-1,-1};
            int[] nums2 = new int[]{2,-5,-2,-4,3};
            int result = solution.maxProduct(nums1);
            System.out.println(result);
        }
    }

}
