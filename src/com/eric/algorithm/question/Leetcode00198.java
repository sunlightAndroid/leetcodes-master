package com.eric.algorithm.question;

import java.util.HashMap;
import java.util.Map;

public class Leetcode00198 {

    /**
     * 解法一：动态规划
     * 思路：求解第N个房屋获取的金额最大值，由于相邻的房屋不能获取，
     * 那么相对于N-1来说，添加一条数据，比如0或者1，很小的数并不会影响N的结果，还是f(n-1)；
     * 而相对于N-2来说，添加一条数据，这个可能就影响结果了，f(n-2) + current
     * f(n) = Max(f(n-1), f(n-2) + current)
     *
     * 或者就是01背包问题，路过第i个房间选择偷还是不偷的问题，偷的话，i-1就不能选了，就是f（i-2）+ value
     * 或者不偷，还是上个金额数目 f（i-1）
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }

    /**
     * 解法二：递归，自顶向下
     * f(n) = Max(f(n-1), f(n-2) + current)
     * 这样会超时
     */
    public int rob2(int[] nums) {
        return dfs(nums, nums.length - 1);
    }

    public int dfs(int[] nums, int index) {
        if (nums.length == 0) return 0;
        if (index == 0) return nums[0];
        if (index == 1) return Math.max(nums[0], nums[1]);
        return Math.max(dfs(nums, index - 1), dfs(nums, index - 2) + nums[index]);
    }

    /**
     * 优化dfs 记忆化搜索
     */
    Map<Integer, Integer> map = new HashMap<>();
    public int dfss(int[] nums, int index) {
        if (nums.length == 0) return 0;
        if (index == 0) return nums[0];
        if (index == 1) return Math.max(nums[0], nums[1]);
        if (!map.containsKey(index - 1)) {
            map.put(index - 1, dfss(nums, index - 1));
        }
        if (!map.containsKey(index - 2)) {
            map.put(index - 2, dfss(nums, index - 2));
        }
        return Math.max(map.get(index - 1), map.get(index - 2)+ nums[index]);
    }


    static class Test {
        public static void main(String[] args) {
            Leetcode00198 solution = new Leetcode00198();
            int result = solution.rob2(new int[]{2, 7, 9, 3, 1});
            System.out.println(result);
        }
    }
}
