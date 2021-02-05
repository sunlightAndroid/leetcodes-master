package com.eric.algorithm.question;

public class Leetcode000494 {

    //  [1, 1, 1, 1, 1], S: 3

    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        find(nums, 0, 0, S);
        return count;
    }
    private void find(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            if(target == sum) count++;
        }else {
            find(nums, index + 1, sum + nums[index], target);
            find(nums, index + 1, sum - nums[index], target);
        }
    }

    public static class Test {
        public static void main(String[] args) {
            Leetcode000494 solution = new Leetcode000494();
            int[] nums = {1, 1, 1, 1, 1};
            int s = 3;

            int[] nums1 = {1, 0};
            int s1 = 1;


            int result = solution.findTargetSumWays(nums, s);
            System.out.println(result);
        }
    }
}
