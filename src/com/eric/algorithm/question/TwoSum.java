package com.eric.algorithm.question;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        int[] result  = twoSum(nums,target);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "  ");
        }


    }

    /**
     * Input: [2,7,11,15], target = 9
     * Output: [0,1]
     * Output: Because nums[0] +nums[1] == 9, we return [0, 1].
     *
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     */
    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {

            for (int j = i+1; j < nums.length; j++) {

                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

}
