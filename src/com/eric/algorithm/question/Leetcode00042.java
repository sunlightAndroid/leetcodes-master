package com.eric.algorithm.question;

public class Leetcode00042 {

    //-------------------暴力解法begin----------------------//
    // 计算每个i的存水量，为了计算这个需要遍历左边跟右边所有的板子，找到两边最长板，然后取两者的最小值。（取决于短板）
    // 但是为了每次为了找 i的左右两边的最长板子，时间复杂度太高。第二个版本优化
    public int trap(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int total = 0;
        for (int i = 1; i < height.length; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            int currentTrap = Math.max(Math.min(leftMax, rightMax) - height[i],0);
            total += currentTrap;
        }
        return total;
    }
    //-------------------暴力解法end----------------------//

    //-------------------动态规划解法begin----------------------//
    public int trap2(int[] height) {
        if (height == null || height.length <= 1) return 0;
        // 耗时主要在于求 当前i左右两边的最长板，所以通过动态规划备忘录的方式给存储起来
        // dpL[i] 表示前i个板子 最长板
        int[] dpL = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            dpL[i] = Math.max(dpL[i - 1], height[i - 1]);
        }
        // dpR[i] 表示i到n的最长板子
        int[] dpR = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            dpR[i] = Math.max(dpR[i + 1], height[i + 1]);
        }
        int total = 0;
        for (int i = 1; i < height.length; i++) {
            int leftMax = dpL[i];
            int rightMax = dpR[i];
            int currentTrap = Math.max(Math.min(leftMax, rightMax) - height[i], 0);
            total += currentTrap;
        }
        return total;
    }
    //-------------------动态规划解法end----------------------//

    public static class Test {
        public static void main(String[] args) {
            Leetcode00042 solution = new Leetcode00042();
            int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
            int[] height1 = {4, 2, 0, 3, 2, 5};
            int result = solution.trap2(height1);
            System.out.println(result);
        }
    }
}
