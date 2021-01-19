package com.eric.algorithm.question;

import java.util.Arrays;

public class Leetcode000300 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength= 0;
        for (int i = 1; i < nums.length; i++) {
            int maxDp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    maxDp = Math.max(maxDp, dp[j]);
                }
            }
            dp[i] = maxDp == 0 ? 1 : maxDp + 1;
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode000300 solution = new Leetcode000300();
//            int[] nums  = new int[]{10,9,2,5,3,7,101,18};
//            int[] nums = new int[]{0, 1, 0, 3, 2, 3};
            int[] nums = new int[]{4, 10, 4, 3, 8, 9};
            int result = solution.lengthOfLIS(nums);
            System.out.println(result);
        }
    }

}
