package com.eric.algorithm.question;

public class Leetcode000560 {

    // nums = [1,2,3], k = 3   => 2
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode000560 solution = new Leetcode000560();
            int[] nums = {1,2,3}; int k = 3;
            int[] nums1 = {1,-1,0}; int k1 = 0;
            int result = solution.subarraySum(nums, k);
            System.out.println(result);
        }
    }
}
