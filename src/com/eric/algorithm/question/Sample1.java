package com.eric.algorithm.question;

public class Sample1 {
    public static void main(String[] args) {

        int[] nums = new int[] { 1, 2, 3, 4 };
        int[] result = runningSum(nums);
        for (int i = 0; i < result.length; i++) {
            int j = result[i];
            System.out.println(j);
        }

    }

    /**
     * Input: [1,2,3,4] Output: [1,3,6,10]
     */
    public static int[] runningSum(int[] nums) {

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = nums[i];
            } else {
                int sum = 0;
                for (int j = 0; j <= i; j++) {
                    sum = sum + nums[j];
                }
                result[i] = sum;
            }
        }

        return result;
    }
}
