package com.eric.algorithm.question;

public class Leetcode00283 {

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 双指针 优化一下
     */
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] =nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++ ){
            nums[i] = 0;
        }
    }

    static class Test {
        public static void main(String[] args) {
            Leetcode00283 solution = new Leetcode00283();
        }
    }
}
